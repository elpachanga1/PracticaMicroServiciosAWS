package com.pachanga.appdeposit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.pachanga.appdeposit.dto.TransactionRequest;
import com.pachanga.appdeposit.message.TransactionMessagePublish;
import com.pachanga.appdeposit.model.TransactionModel;
import com.pachanga.appdeposit.service.ITransactionService;
 
@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
 
    @Autowired
    ITransactionService transactionService;
    @Autowired
	TransactionMessagePublish messageEvent;
	
    Logger logger = LoggerFactory.getLogger(TransactionController.class);
    
    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody TransactionRequest request) throws Exception {
    	Integer accountId = request.getAccountId();
    	Double amount = request.getAmount();
    	
    	logger.info("Post: AccountId {} - Ammount {}", accountId, amount);
    	
    	// mapping the transaction
    	TransactionModel model = new TransactionModel();
    	
    	model.setAccountId(accountId);
    	model.setAmount(amount);
        model.setType("deposit");
    	transactionService.add(model);
    	
    	// sending to kafka
    	messageEvent.sendDepositEvent(model).get();
    	return new ResponseEntity<TransactionModel>(model, null, HttpStatus.CREATED);
    }
}