package com.pachanga.appwithdrawal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pachanga.appwithdrawal.model.WithdrawalModel;
 
@Repository
public interface IWithdrawalRepository extends CrudRepository<WithdrawalModel, Long>{
    
}
