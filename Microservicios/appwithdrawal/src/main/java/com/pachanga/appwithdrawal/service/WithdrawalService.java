package com.pachanga.appwithdrawal.service;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.pachanga.appwithdrawal.model.WithdrawalModel;
import com.pachanga.appwithdrawal.repository.IWithdrawalRepository;
 
@Service
public class WithdrawalService  implements IWithdrawalService {
 
    @Autowired
	private IWithdrawalRepository transactionRepositoy;
 
    @Override
    @Transactional
    public WithdrawalModel add(WithdrawalModel withdrawalModel) {
        return transactionRepositoy.save(withdrawalModel);
    }
}
