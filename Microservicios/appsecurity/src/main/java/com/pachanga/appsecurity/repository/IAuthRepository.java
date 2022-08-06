package com.pachanga.appsecurity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
import com.pachanga.appsecurity.model.AccessModel;
 
@Repository
public interface IAuthRepository extends CrudRepository<AccessModel, Long> {
    
}
