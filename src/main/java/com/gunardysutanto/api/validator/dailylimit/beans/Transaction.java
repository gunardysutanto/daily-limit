package com.gunardysutanto.api.validator.dailylimit.beans;
import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
	private static final long serialVersionUID = 1L;
	private long customerId;
	private String transactionCurrency;
	private Date transactionValueDate;
	private BigDecimal transactionAmount;
	private BigDecimal transactionEquivAmount;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public Date getTransactionValueDate() {
		return transactionValueDate;
	}

	public void setTransactionValueDate(Date transactionValueDate) {
		this.transactionValueDate = transactionValueDate;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public BigDecimal getTransactionEquivAmount() {
		return transactionEquivAmount;
	}

	public void setTransactionEquivAmount(BigDecimal transactionEquivAmount) {
		this.transactionEquivAmount = transactionEquivAmount;
	}
}
