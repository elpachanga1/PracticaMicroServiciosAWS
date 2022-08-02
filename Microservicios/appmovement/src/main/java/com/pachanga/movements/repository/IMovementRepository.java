package com.pachanga.movements.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
 
import com.pachanga.movements.model.MovementModel;
 
@Repository
public interface IMovementRepository extends MongoRepository<MovementModel, String>  {
    @Query("{'accountId':?0}")
	public Iterable<MovementModel> findByAccountId(Integer accountId);
}
