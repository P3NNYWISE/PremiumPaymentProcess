package com.northstarlife.servicing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class BatchPayment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String batchIdentifier;
	private Date paymentDate;
	private ArrayList<String> excludedPolicyNumbers;
	
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getBatchIdentifier() {
		return batchIdentifier;
	}
	public void setBatchIdentifier(String batchIdentifier) {
		this.batchIdentifier = batchIdentifier;
	}
	public ArrayList<String> getExcludedPolicyNumbers() {
		return excludedPolicyNumbers;
	}
	public void setExcludedPolicyNumbers(ArrayList<String> excludedPolicyNumbers) {
		this.excludedPolicyNumbers = excludedPolicyNumbers;
	}
}