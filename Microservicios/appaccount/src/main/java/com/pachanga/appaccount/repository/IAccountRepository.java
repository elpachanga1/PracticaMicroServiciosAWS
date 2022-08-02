package com.pachanga.appaccount.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pachanga.appaccount.model.AccountModel;
 
@Repository
public interface IAccountRepository extends CrudRepository<AccountModel,Integer> {
    
}
