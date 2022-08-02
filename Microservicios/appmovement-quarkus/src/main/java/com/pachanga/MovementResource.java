package com.pachanga;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
import com.pachanga.entity.Transaction;
import com.pachanga.service.ITransactionService;
 
@Path("/api/movement")
public class MovementResource {
 
    @Inject
   	ITransactionService service;
    
    @GET
   	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
   	@Path("/listar")
   	public List<Transaction> getTransaction() {
   		return service.listAll();
   	}
	
}
