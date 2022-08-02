package com.pachanga.appdeposit.service;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.pachanga.appdeposit.model.TransactionModel;
import com.pachanga.appdeposit.repository.ITransactionRepository;
 
@Service
public class TransactionService  implements ITransactionService {
 
    @Autowired
	private ITransactionRepository transactionRepositoy;
 
    @Override
    @Transactional
    public TransactionModel add(TransactionModel transactionModel) {
        return transactionRepositoy.save(transactionModel);
    }
}
