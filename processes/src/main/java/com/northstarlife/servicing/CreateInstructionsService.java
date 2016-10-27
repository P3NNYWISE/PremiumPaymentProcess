package com.northstarlife.servicing;

import java.util.List;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.northstar.slxclient.client.api.ClientGroupsApi;
import com.northstar.slxclient.client.model.ClientGroup;

import com.northstar.slxclient.client.api.PremiumRequestsApi;

import com.northstar.slxclient.client.model.PremiumRequest;
import com.northstar.slxclient.client.base.ApiException;

import com.northstar.slxclient.client.model.PremiumRequestBatch;
import com.northstar.slxclient.client.model.PremiumrequestInput;

import java.util.Date;
import org.joda.time.LocalDate;


import com.northstarlife.Utils;


public class CreateInstructionsService implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		
		// CreateBatchPayment objects
		PremiumRequestProcessState state = (PremiumRequestProcessState) execution.getVariable("state");

		//Set default approved
		state.setApproved(false);
		
		// We should now call the API to create the instructions
	

		/***
		create Api Instance
		***/
		PremiumRequestsApi apiInstance = new PremiumRequestsApi();
		apiInstance.getApiClient().setBasePath("http://zsqbkee7tah5mmf4a-mock.stoplight-proxy.io/slx-api/v1");
		
		// Build Premiumrequestinput 
		PremiumrequestInput body = new PremiumrequestInput(); 
		body.setClientGroupId(state.getClientGroupId()	);
		
		body.setFrom(state.getStartDate());		
		body.setTo(state.getEndDate());
		body.setAmountOfFiles(state.getAmountOfFiles());
		body.setCheckAsPDF(state.getCheckAsPdf());

		for (Date paymentDate : state.getPaymentDates()) {
        	body.addPaymentDatesItem(paymentDate);
		}
		Utils.Log.info(">>> " + body);
		
		/***
		add Premium Request
		***/
		try {
		    PremiumRequest premiumRequest = apiInstance.addPremiumRequest(body);
		    
		    Utils.Log.info(">>> " + premiumRequest);
		} catch (ApiException e) {
		    Utils.Log.info(">>> Exception when calling PremiumRequestsApi#addPremiumRequest");
		    e.printStackTrace();
		}
		/***	
		Get Premium Request
		**/

/*		String id = "1"; // String | 
		
		Boolean includePolicyDetail = false; // Boolean | 
		try {
			    PremiumRequest result = apiInstance.getPremiumRequest(id, includePolicyDetail);
			    Utils.Log.info(">>> " + result);
			   
		} catch (ApiException e) {
			     Utils.Log.info(">>> Exception when calling PremiumRequestsApi#addPremiumRequest");
			    e.printStackTrace();
		}
*/		
		//set premium request  From API  
		PremiumRequest request = new PremiumRequest();
		request.setId("1");

		state.setRequest(request);

		    
		
		// We now add batchPayments records for each batch returned in the API
		// We will use it to keep track of input for each batch on the multiinstance activity (Confirm Batch Payment)
		//Simulated Batches
		for (int i=1 ; i<=4 ; i++){
			PremiumRequestBatch batchPayment = new PremiumRequestBatch();
			batchPayment.setId(String.valueOf(i));
			state.getBatchPayments().add(batchPayment);
		}
		
		 

		
		
		/*
		for (	PremiumRequestBatch batch : request.getBatches() ) {
   				state.getBatchPayments().add(batch);
		}
		*/
		// Add the variable, not sure if needed.		
		execution.setVariable("state", state);
		


		
		Utils.Log.info("Created Instructions");
	}

}
