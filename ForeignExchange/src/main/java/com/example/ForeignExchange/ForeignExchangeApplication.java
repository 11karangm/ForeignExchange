package com.example.ForeignExchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.example.ForeignExchange.controller",
    "com.example.ForeignExchange.service",
    "com.example.ForeignExchange.DTO"
}) 
public class ForeignExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForeignExchangeApplication.class, args);
	}

}
