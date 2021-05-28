package com.apiprovider.customer;

public class Customer{

	private final int hourleyQuotaOfCalls;
	private final String customerName;

	public Customer(String customerName, int hourleyQuotaOfCalls, CustomerCallCounts customerCallCounter) {
		this.hourleyQuotaOfCalls = hourleyQuotaOfCalls;
		this.customerName = customerName;
		customerCallCounter.addCustomer(customerName);

	}

	public String getName() {
		return customerName;
	}

	public int getAllowedCallsQuota() {
		return hourleyQuotaOfCalls;
	}

}
