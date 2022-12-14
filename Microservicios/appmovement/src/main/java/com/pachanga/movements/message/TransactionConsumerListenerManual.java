package com.pachanga.movements.message;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
 
import com.pachanga.movements.dto.TransactionRequest;
import com.pachanga.movements.model.MovementModel;
import com.pachanga.movements.service.IMovementService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@Component
public class TransactionConsumerListenerManual implements AcknowledgingMessageListener<Integer, String>  {
 
	@Autowired
    private IMovementService movementService;
	
    @Autowired
    private ObjectMapper objectMapper;
    
    private Logger log = LoggerFactory.getLogger(TransactionConsumerListenerManual.class);
    
	
	@Override
	@KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void onMessage(ConsumerRecord<Integer, String> data, Acknowledgment acknowledgment) {
		// TODO Auto-generated method stub
		
		try {
 
            log.info("****************************************************************");
            log.info("****************************************************************");
            log.info("Consumer Receives in Microservice Account");
            log.info("ConsumerRecord : {}", data.value());
 
            TransactionRequest requestEvent = objectMapper.readValue(data.value(), TransactionRequest.class);
 
            log.info("Id Transaction: {} -  Type: {} - Ammount: {}", requestEvent.getId(), requestEvent.getType(),
                    requestEvent.getAmount());
 
            MovementModel movementModel = new MovementModel();
            movementModel.setAccountId(requestEvent.getAccountId());
            movementModel.setAmount(requestEvent.getAmount());
            movementModel.setCreationDate(requestEvent.getCreationDate());
            
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());

            movementModel.setProcessDate(formatter.format(date));
            
            //movementModel = (MovementModel) movementService.findByAccountId(requestEvent.getAccountId());
            
            movementService.add(movementModel);
            
            log.info("Update account {}", requestEvent.getAccountId());
            
            //Commit kafka
            acknowledgment.acknowledge();
 
            log.info("****************************************************************");
            log.info("****************************************************************");
 
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
       
    }
}
