package com.pachanga.appaccount.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pachanga.appaccount.dto.TransactionRequest;
import com.pachanga.appaccount.message.TransactionConsumerListenerManual;
import com.pachanga.appaccount.model.AccountModel;
import com.pachanga.appaccount.service.IAccountService;

@RestController
@RequestMapping("/api/transaction")
public class AccountController {
 
    @Autowired
    IAccountService accountService;
    @Autowired
    TransactionConsumerListenerManual consumerListener;
	
    Logger logger = LoggerFactory.getLogger(AccountController.class);
    
    @GetMapping("/account")
    public ResponseEntity<?> findAllAccounts() throws Exception {
    	List<AccountModel> accounts = accountService.findAll();
    	if (accounts == null || accounts.isEmpty()) return ResponseEntity.notFound().build();
    	return ResponseEntity.ok(accounts);
    }
}
