package com.pachanga.movements.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pachanga.movements.model.MovementModel;
import com.pachanga.movements.repository.IMovementRepository;

@Service
public class MovementService implements IMovementService {
 
    @Autowired
	IMovementRepository movementRepository;

    @Override
    public MovementModel add(MovementModel movement) {
    	return movementRepository.insert(movement);
    }

    @Override
	public Iterable<MovementModel> findByAccountId(Integer accountId) {
		return movementRepository.findByAccountId(accountId);
	}

    @Override
	public Iterable<MovementModel> findAll() {
    	return movementRepository.findAll();
    }
}
