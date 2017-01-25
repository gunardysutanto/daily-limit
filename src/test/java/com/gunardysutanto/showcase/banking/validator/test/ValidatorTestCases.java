package com.gunardysutanto.showcase.banking.validator.test;

//TestNG import(s)
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.sql.Date;

//API import(s)
import com.gunardysutanto.api.validator.dailylimit.beans.Transaction;
import com.gunardysutanto.api.validator.dailylimit.exception.DailyLimitViolationException;
import com.gunardysutanto.api.validator.dailylimit.beans.DailyLimit;
import com.gunardysutanto.showcase.banking.validator.test.impl.SimpleDailyLimitImpl;

public class ValidatorTestCases {
    private Transaction transaction;
    private DailyLimit dailyLimit;
    private SimpleDailyLimitImpl impl;
    
    @BeforeTest
    public void constructTestData() {
    	transaction = new Transaction();
    	transaction.setCustomerId(1101);
    	transaction.setTransactionAmount(new BigDecimal(1000));
    	transaction.setTransactionEquivAmount(new BigDecimal(7577.26));
    	transaction.setTransactionCurrency("EUR");
    	transaction.setTransactionValueDate(new Date(System.currentTimeMillis()));
    	
    	impl = new SimpleDailyLimitImpl();
    	dailyLimit = impl.retriveDailyLimit(transaction.getCustomerId());
    }
        
	@Test(expectedExceptions = DailyLimitViolationException.class)
	public void alreadyReachedMaxDailyLimit() throws DailyLimitViolationException {
       impl.validate(transaction);
	}

}
