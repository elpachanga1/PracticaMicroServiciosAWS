package com.pachanga.movements.metric;

import org.springframework.stereotype.Component;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
 
@Component
public class IncreaseCounterMovement {
 
	
	private final Counter movementGetCounter;
	
	public IncreaseCounterMovement(MeterRegistry meterRegistry) {
		
		movementGetCounter=meterRegistry.counter("account.get");
	}
	
	public void increaseCounter() {
		
		movementGetCounter.increment();
	}
}
