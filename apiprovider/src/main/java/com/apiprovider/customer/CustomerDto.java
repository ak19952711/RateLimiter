package com.apiprovider.customer;

import org.springframework.beans.factory.annotation.Value;

public class CustomerDto {

	private String apiKey;
	
  

	CustomerDto(String CustomerDto){
		this.apiKey=apiKey;
	}
	
    
	public String getApiKey() {
		return apiKey;
	}


	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}




	
}
