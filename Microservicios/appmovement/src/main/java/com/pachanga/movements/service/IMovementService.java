package com.pachanga.movements.service;

import com.pachanga.movements.model.MovementModel;

public interface IMovementService {
    public MovementModel add (MovementModel movement);
	public Iterable<MovementModel> findByAccountId (Integer accountId);
	public Iterable<MovementModel>  findAll() ;
}
