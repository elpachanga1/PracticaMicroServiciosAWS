package com.pachanga.consumer;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
 
import org.eclipse.microprofile.reactive.messaging.Incoming;
 
import com.pachanga.entity.Transaction;
 
public class TransactionConsumer {
 
	@Incoming("transactions")
	public void reciveTransactionHistorical(Transaction trx) {
		System.out.println("===================== MICROSERVICE HISTORICAL ==============================");
		Jsonb create = JsonbBuilder.create();
		String json = create.toJson(trx);
		System.out.println(String.format("Transaction : %s", json));
		Transaction trxHistorical =trx;
		trxHistorical.persist();   
	    System.out.println("Transaction save "+trx.getId());	
	}
}
