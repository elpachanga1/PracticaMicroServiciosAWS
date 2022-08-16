package com.pachanga.appwithdrawal.metric;

import org.springframework.stereotype.Component;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
 
@Component
public class IncreaseCounterWithdrawal {	
	private final Counter withdrawalGetCounter;
	
	public IncreaseCounterWithdrawal(MeterRegistry meterRegistry) {
		withdrawalGetCounter=meterRegistry.counter("withdrawal.get");
	}
	
	public void increaseCounter() {
		withdrawalGetCounter.increment();
	}
}