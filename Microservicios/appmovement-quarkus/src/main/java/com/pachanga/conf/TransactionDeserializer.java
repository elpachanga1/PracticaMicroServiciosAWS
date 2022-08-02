package com.pachanga.conf;

import com.pachanga.entity.Transaction;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;
public class TransactionDeserializer extends JsonbDeserializer<Transaction> {
 
	public TransactionDeserializer() {
		super(Transaction.class);		
	}
}
