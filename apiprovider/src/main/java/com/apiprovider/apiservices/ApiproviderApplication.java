package com.apiprovider.apiservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.apiprovider.customer.CustomerCallCounts;

@SpringBootApplication
public class ApiproviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiproviderApplication.class, args);
	}

	
	@Bean
	@Scope("prototype")
	public CustomerCallCounts getCallsLog() {
	    return new CustomerCallCounts();
	}
	
}
