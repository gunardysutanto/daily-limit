package com.gunardysutanto.api.validator.dailylimit;

//Core Java import(s)
import java.math.BigDecimal;

//SLF4J import(s)
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//API import(s)
import com.gunardysutanto.api.validator.dailylimit.beans.Transaction;
import com.gunardysutanto.api.validator.dailylimit.beans.DailyLimit;
import com.gunardysutanto.api.validator.dailylimit.exception.DailyLimitViolationException;

public abstract class GenericDailyLimitValidator {
	private static Logger logger = LoggerFactory.getLogger(GenericDailyLimitValidator.class);
    public void validate(Transaction transaction) throws DailyLimitViolationException {
    	if(transaction!=null) {
    		   DailyLimit dailyLimit = retriveDailyLimit(transaction.getCustomerId());
    		   if(dailyLimit.getBaseCurrency().equals(transaction.getTransactionCurrency())) {
                  if(dailyLimit.getDailyLimit().compareTo(transaction.getTransactionAmount().add(dailyLimit.getUtilizedLimit()))<0){
                	 logger.debug(" validation failed.. ");
                   	 throw new DailyLimitViolationException(dailyLimit.getDailyLimit(), dailyLimit.getUtilizedLimit().add(transaction.getTransactionAmount()));
                  } else
                	  updateUtilizedLimit(dailyLimit, dailyLimit.getUtilizedLimit().add(transaction.getTransactionAmount())); 
    		   } else if(!dailyLimit.getBaseCurrency().equals(transaction.getTransactionCurrency())) {
                   if(dailyLimit.getDailyLimit().compareTo(transaction.getTransactionEquivAmount().add(dailyLimit.getUtilizedLimit()))<0){
                	   logger.debug(" validation failed.. ");
                	   throw new DailyLimitViolationException(dailyLimit.getDailyLimit(), dailyLimit.getUtilizedLimit().add(transaction.getTransactionEquivAmount()));
                    } else
                    	updateUtilizedLimit(dailyLimit, dailyLimit.getUtilizedLimit().add(transaction.getTransactionEquivAmount())); 
    		   }
    	}
    }
    
    public abstract DailyLimit retriveDailyLimit(long customerId);
    
    public abstract void updateUtilizedLimit(DailyLimit dailyLimit, BigDecimal newLimitAmount);
}
