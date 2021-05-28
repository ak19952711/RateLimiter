package com.apiprovider.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiprovider.customer.Customer;
import com.apiprovider.customer.CustomerCallCounts;
import com.apiprovider.customer.CustomerDto;
import com.apiprovider.ratelimiter.RateLimiter;
import com.apiprovider.ratelimiter.RateLimiterImpl;
import com.apiprovider.service.ApiService;



@RestController
@RequestMapping("/apihub")
public class RateLimiterController {

	@Autowired
	private CustomerCallCounts callsCount;
	
	@Value("${ratelimiter.balance.load.serve}")
	int serveNRequests;
	
	@Value("${ratelimiters.api.allowed.per.hour}")
	int hourlyCalls;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/api")
	public void getApiResponse(@RequestBody CustomerDto customerDto) {
	   
	    Customer customer = new Customer(customerDto.getApiKey(), hourlyCalls, callsCount);

	    ExecutorService executorService = Executors.newFixedThreadPool(serveNRequests);
	    executorService.execute(() -> makeServiceCalls(customer, callsCount));

		
	  }
	
    private static void makeServiceCalls(Customer customer, CustomerCallCounts callsCount) {
	    RateLimiter timer = new RateLimiterImpl(10, callsCount);
	    ApiService service = new ApiService(timer, callsCount);
	    IntStream.range(0, 20).forEach(i -> {
	      service.dummyCustomerApi(customer);
	      try {
	        Thread.sleep(1);
	      } catch (InterruptedException e) {
            e.printStackTrace();
	      }
	    });
	
}
    
}
