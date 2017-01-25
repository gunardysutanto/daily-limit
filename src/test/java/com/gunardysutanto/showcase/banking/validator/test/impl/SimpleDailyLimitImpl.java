package com.gunardysutanto.showcase.banking.validator.test.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gunardysutanto.api.validator.dailylimit.GenericDailyLimitValidator;
import com.gunardysutanto.api.validator.dailylimit.beans.DailyLimit;

public class SimpleDailyLimitImpl extends GenericDailyLimitValidator {
	private static Logger logger = LoggerFactory.getLogger(SimpleDailyLimitImpl.class);
	@Override
	public DailyLimit retriveDailyLimit(long customerId) {
		DailyLimit dailyLimit = new DailyLimit();
		dailyLimit.setCustomerId(customerId);
		dailyLimit.setBaseCurrency("SGD");
		dailyLimit.setDailyLimit(new BigDecimal(1000));
		dailyLimit.setUtilizedLimit(new BigDecimal(500));
		return dailyLimit;
	}
	
	
	@Override
	public void updateUtilizedLimit(DailyLimit dailyLimit, BigDecimal newLimit) {
		if(dailyLimit!=null)
		  dailyLimit.setUtilizedLimit(newLimit);	
	}

}
