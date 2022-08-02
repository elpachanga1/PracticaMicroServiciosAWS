package com.pachanga.service;

import java.util.List;

import com.pachanga.entity.Transaction;
 
public interface ITransactionService {
	public Transaction saveDocument (Transaction transaction);
	public List<Transaction> listAll();
}
