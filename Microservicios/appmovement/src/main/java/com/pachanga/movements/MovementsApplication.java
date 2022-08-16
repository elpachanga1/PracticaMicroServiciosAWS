package com.pachanga.movements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MovementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovementsApplication.class, args);
	}

}
