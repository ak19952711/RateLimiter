package com.apiprovider.service;

import java.util.concurrent.ThreadLocalRandom;

import com.apiprovider.customer.Customer;
import com.apiprovider.customer.CustomerCallCounts;
import com.apiprovider.ratelimiter.RateLimiter;

public class ApiService {


	  private final CustomerCallCounts customerCallCounts;

	  public ApiService(RateLimiter rateLimiter, CustomerCallCounts customerCallCounts) {
	    this.customerCallCounts = customerCallCounts;
	    rateLimiter.limit();
	  }

	  public int dummyCustomerApi(Customer customer) {
	    String customerName = customer.getName();
	    int count = customerCallCounts.getCount(customerName);
	   
	    if (count >= customer.getAllowedCallsQuota()) {
	     
	      return -1;
	    }
	    customerCallCounts.incrementCount(customerName);
	    return getRandomCustomerId();
	  }

	  private int getRandomCustomerId() {
	    return ThreadLocalRandom.current().nextInt(1, 10000);
	  }
}
