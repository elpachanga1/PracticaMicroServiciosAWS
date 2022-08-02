package com.pachanga.appdeposit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
import com.pachanga.appdeposit.model.TransactionModel;
 
@Repository
public interface ITransactionRepository extends CrudRepository<TransactionModel, Long>{
    
}
