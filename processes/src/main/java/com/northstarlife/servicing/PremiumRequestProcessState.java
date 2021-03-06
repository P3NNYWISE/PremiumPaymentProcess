package com.northstarlife.servicing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.northstar.slxclient.client.model.PremiumRequest;
import com.northstar.slxclient.client.model.PremiumRequestBatch;
import com.northstar.slxclient.client.model.Policy ;
import com.northstar.slxclient.client.model.PolicyPremium;
	
public class PremiumRequestProcessState implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Fields for STEP 1
	private String clientGroupId;
	private String amountOfFiles;
	private String paymentAgentId;
	private Boolean checkAsPdf;
	private Date startDate;
	private Date endDate;
	private ArrayList<Date> paymentDates = new ArrayList<Date>();
	
	// Fields for STEP 2
	private Boolean approved;

	// Responses from STEP 3 (Multiple)
	//private Collection<BatchPayment> batchPayments = new ArrayList<BatchPayment>();
	private Collection<PremiumRequestBatch> batchPayments = new ArrayList<PremiumRequestBatch>();

	
	// TODO: This object should be the PremiumRequest retrieved from the API
	//private String request;
	private PremiumRequest request;

	// Current Premium response from STEP 3 
	//private Collection<BatchPayment> batchPayments = new ArrayList<BatchPayment>();
	private Collection<Policy> policy = new ArrayList<Policy>();



	public String getClientGroupId() {
		return clientGroupId;
	}

	public void setClientGroupId(String clientGroupId) {
		this.clientGroupId = clientGroupId;
	}

	public String getAmountOfFiles() {
		return amountOfFiles;
	}

	public void setAmountOfFiles(String amountOfFiles) {
		this.amountOfFiles = amountOfFiles;
	}

	public String getPaymentAgentId() {
		return paymentAgentId;
	}

	public void setPaymentAgentId(String paymentAgentId) {
		this.paymentAgentId = paymentAgentId;
	}

	public Boolean getCheckAsPdf() {
		return checkAsPdf;
	}

	public void setCheckAsPdf(Boolean checkAsPdf) {
		this.checkAsPdf = checkAsPdf;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ArrayList<Date> getPaymentDates() {
		return paymentDates;
	}

	public void setPaymentDates(ArrayList<Date> paymentDates) {
		this.paymentDates = paymentDates;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Collection<PremiumRequestBatch> getBatchPayments() {
		return batchPayments;
	}

	public void setBatchPayments(Collection<PremiumRequestBatch> batchPayments) {
		this.batchPayments = batchPayments;
	}

	public PremiumRequest getRequest() {
		return request;
	}

	public void setRequest(PremiumRequest request) {
		this.request = request;
	}
	public Collection<Policy> getPolicy() {
		return policy;
	}

	public void setPolicy(Collection<Policy> policy) {
		this.policy = policy;
	}

}
