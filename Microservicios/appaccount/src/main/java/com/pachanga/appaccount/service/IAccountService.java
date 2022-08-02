package com.pachanga.appaccount.service;

import java.util.List;

import com.pachanga.appaccount.model.AccountModel;
 
public interface IAccountService {
    
    public List<AccountModel> findAll();
    public AccountModel findById (Integer id); 
    public AccountModel update(AccountModel accountModel);
}
