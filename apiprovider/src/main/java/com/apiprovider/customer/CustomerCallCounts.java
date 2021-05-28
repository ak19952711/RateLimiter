package com.apiprovider.customer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class CustomerCallCounts {

	
	  private final Map<String, AtomicInteger> customerCallsCount = new ConcurrentHashMap<>();

	  public void addCustomer(String customerName) {
		  customerCallsCount.putIfAbsent(customerName, new AtomicInteger(0));
	  }

	  public void incrementCount(String customerName) {
		  customerCallsCount.get(customerName).incrementAndGet();
	  }

	  public int getCount(String customerName) {
	    return customerCallsCount.get(customerName).get();
	  }

	  public void resetCallsLogger() {
//	    LOGGER.debug("Resetting the map.");
	    customerCallsCount.replaceAll((k, v) -> new AtomicInteger(0));
	  }
}
