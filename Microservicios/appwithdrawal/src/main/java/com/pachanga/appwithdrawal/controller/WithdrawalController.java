package com.pachanga.appwithdrawal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pachanga.appwithdrawal.service.IWithdrawalService;
import com.pachanga.appwithdrawal.dto.WithdrawalRequest;
import com.pachanga.appwithdrawal.message.TransactionMessagePublish;
import com.pachanga.appwithdrawal.model.WithdrawalModel;
 
@RestController
@RequestMapping("/api/transaction")
public class WithdrawalController {
 
    @Autowired
    IWithdrawalService withdrawalService;
    @Autowired
	TransactionMessagePublish messageEvent;
	
    Logger logger = LoggerFactory.getLogger(WithdrawalController.class);
    
    @PostMapping("/withdrawal")
    public ResponseEntity<?> deposit(@RequestBody WithdrawalRequest request) throws Exception {
    	Integer accountId = request.getAccountId();
    	Double amount = request.getAmount();
    	
    	logger.info("Post: AccountId {} - Ammount {}", accountId, amount);
    	
    	// mapping the transaction
    	WithdrawalModel model = new WithdrawalModel();
    	
    	model.setAccountId(accountId);
    	model.setAmount(amount);
        model.setType("deposit");
        withdrawalService.add(model);
    	
    	// sending to kafka
    	messageEvent.sendDepositEvent(model).get();
    	return new ResponseEntity<WithdrawalModel>(model, null, HttpStatus.CREATED);
    }
}