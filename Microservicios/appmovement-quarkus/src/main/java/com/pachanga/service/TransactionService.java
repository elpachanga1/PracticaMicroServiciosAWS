package com.pachanga.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
 
import com.pachanga.entity.Transaction;
import com.pachanga.repository.TransactionRepository;
 
@ApplicationScoped
public class TransactionService implements ITransactionService {
 
	@Inject
	TransactionRepository mongoRepo ; 
	
	
	@Override
	public Transaction saveDocument(Transaction transaction) {
		// TODO Auto-generated method stub
		transaction.persistOrUpdate();
		return transaction;
	}
 
	@Override
	public List<Transaction> listAll() {
		// TODO Auto-generated method stub
		return mongoRepo.listAll();
	}
 
}
