package com.pachanga.appdeposit.metric;

import org.springframework.stereotype.Component;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
 
@Component
public class IncreaseCounterDeposit {
 
	
	private final Counter depositGetCounter;
	
	public IncreaseCounterDeposit(MeterRegistry meterRegistry) {
		depositGetCounter=meterRegistry.counter("deposit.get");
	}
	
	public void increaseCounter() {
		depositGetCounter.increment();
	}
}
