package com.apiprovider.ratelimiter;

import java.util.Timer;
import java.util.TimerTask;

import com.apiprovider.customer.CustomerCallCounts;

public class RateLimiterImpl implements RateLimiter{


	  private final int blockPeriod;
	  private final CustomerCallCounts customerCallCounts;

	  public RateLimiterImpl(int blockPeriod, CustomerCallCounts customerCallCounts) {
	    this.blockPeriod = blockPeriod;
	    this.customerCallCounts = customerCallCounts;
	  }

	  @Override
	  public void limit() {
	    new Timer(true).schedule(new TimerTask() {
	      @Override
	      public void run() {
	    	  customerCallCounts.resetCallsLogger();
	      }
	    }, 0, blockPeriod);
	  }
	
	
	  
}
