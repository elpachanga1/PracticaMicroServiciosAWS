package com.pachanga.movements.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pachanga.movements.model.MovementModel;
import com.pachanga.movements.repository.IMovementRepository;

@CacheConfig(cacheNames = "transaction")
@Service
public class MovementService implements IMovementService {
 
    @Autowired
	IMovementRepository movementRepository;

    @Override
    public MovementModel add(MovementModel movement) {
    	return movementRepository.insert(movement);
    }

    @Override
	@Cacheable (cacheNames = "transaction" , key = "#accountId")
	public Iterable<MovementModel> findByAccountId(Integer accountId) {
		return movementRepository.findByAccountId(accountId);
	}

    @Override
	public Iterable<MovementModel> findAll() {
    	return movementRepository.findAll();
    }
}
