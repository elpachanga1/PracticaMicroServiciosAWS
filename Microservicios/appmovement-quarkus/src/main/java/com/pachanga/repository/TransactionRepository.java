package com.pachanga.repository;

import javax.enterprise.context.ApplicationScoped;

import com.pachanga.entity.Transaction;
 
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
 
@ApplicationScoped
public class TransactionRepository  implements PanacheMongoRepositoryBase<Transaction, String>{
 
}
