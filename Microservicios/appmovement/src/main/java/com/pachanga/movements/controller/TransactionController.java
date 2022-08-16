package com.pachanga.movements.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pachanga.movements.metric.IncreaseCounterMovement;
import com.pachanga.movements.model.MovementModel;
import com.pachanga.movements.service.IMovementService;

@RestController
@RequestMapping("/api/movement")
public class TransactionController {
 
    @Autowired
    IMovementService service;

    Logger logger = LoggerFactory.getLogger(TransactionController.class);
    
    @Autowired
    IncreaseCounterMovement increaseCounterAccount;
    
    @GetMapping("/listAccounts")
    public ResponseEntity<?> getAll() throws Exception {
    	increaseCounterAccount.increaseCounter();
    
    	List<MovementModel> list = (List<MovementModel>) service.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
