package com.gunardysutanto.api.validator.dailylimit.exception;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DailyLimitViolationException extends Throwable {
	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(DailyLimitViolationException.class);
	
    private static String messageWithoutInfo = "Can't proceed the transaction as the maximum daily limit exceeded.";
    private static String messageWithInfo = "Can't proceed the transaction as the maximum daily limit exceeded (maximum limit = %1$,.2f, utilized limit = %2$,.2f)";
    public DailyLimitViolationException() {
    	super(messageWithoutInfo);
    	logger.debug("throw msg: "+messageWithoutInfo);    	
    }
    
    public DailyLimitViolationException(BigDecimal dailyLimit, BigDecimal utilizedLimit) {
    	super(String.format(messageWithInfo, dailyLimit,utilizedLimit));
    	logger.debug("throw msg: "+String.format(messageWithInfo, dailyLimit,utilizedLimit));
    }
}