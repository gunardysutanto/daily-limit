package com.gunardysutanto.api.validator.dailylimit.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class DailyLimit implements Serializable {
	private static final long serialVersionUID = 1L;
	private long customerId;
	private String baseCurrency;
	private BigDecimal dailyLimit;
	private BigDecimal utilizedLimit;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public BigDecimal getDailyLimit() {
		return dailyLimit;
	}

	public void setDailyLimit(BigDecimal dailyLimit) {
		this.dailyLimit = dailyLimit;
	}

	public BigDecimal getUtilizedLimit() {
		return utilizedLimit;
	}

	public void setUtilizedLimit(BigDecimal utilizedLimit) {
		this.utilizedLimit = utilizedLimit;
	}

}
