package com.northstarlife.servicing;

import java.util.List;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.northstar.slxclient.client.api.ClientGroupsApi;
import com.northstar.slxclient.client.model.ClientGroup;

import com.northstar.slxclient.client.api.PremiumRequestsApi;
import com.northstar.slxclient.client.model.Premiumrequestinput;
import com.northstar.slxclient.client.model.PremiumRequest;
import com.northstar.slxclient.client.base.ApiException;


import java.util.Date;
import org.joda.time.LocalDate;


import com.northstarlife.Utils;


public class CreateInstructionsService implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		
		// CreateBatchPayment objects
		PremiumRequestProcessState state = (PremiumRequestProcessState) execution.getVariable("state");

		// Here we can get the variables from the step and apply to the object if the form did not already directly updated it.
		//Set default approved
		state.setApproved(false);
		
		// We should now call the API to create the instructions
		// TODO



		//create Api Instance
		PremiumRequestsApi apiInstance = new PremiumRequestsApi();
		apiInstance.getApiClient().setBasePath("http://zsqbkee7tah5mmf4a-mock.stoplight-proxy.io/slx-api/v1");
		
		//Add Premium Request
		Premiumrequestinput body = new Premiumrequestinput(); 
		// Build Premiumrequestinput 

		body.setClientGroupId(state.getClientGroupId()	);

		// Convert Data types TODO
		LocalDate today = LocalDate.now();
		//body.setFrom(state.getStartDate());
		body.setFrom(today);
		//body.setTo(state.getEndDate());
		body.setTo(today);
		body.setCheckAsPDF(state.getCheckAsPdf());
		for (Date paymentDate : state.getPaymentDates()) {
        	//body.addPaymentDatesItem(paymentDate);
        	body.addPaymentDatesItem(today);
		}
		
		Utils.Log.info(">>> " + body);
		
		try {
		    PremiumRequest result = apiInstance.addPremiumRequest(body);
		    
		    Utils.Log.info(">>> " + result);
		} catch (ApiException e) {
		    System.err.println("Exception when calling PremiumRequestsApi#addPremiumRequest");
		    Utils.Log.info(">>> Exception when calling PremiumRequestsApi#addPremiumRequest");
		    e.printStackTrace();
		}
	/*
		//Get Premium Request

		String id = "1"; // String | 
		Boolean includePolicyDetail = false; // Boolean | 
		try {
			    PremiumRequest result = apiInstance.getPremiumRequest(id, includePolicyDetail);
			    Utils.Log.info(">>> " + result);
			    System.out.println(result);
		} catch (ApiException e) {
			    System.err.println("Exception when calling PremiumRequestsApi#getPremiumRequest");
			     Utils.Log.info(">>> Exception when calling PremiumRequestsApi#addPremiumRequest");
			    e.printStackTrace();
		}
		
		*/    
		    




		
		// We now add batchPayments records for each batch returned in the API
		// We will use it to keep track of input for each batch on the multiinstance activity (Confirm Batch Payment)
		state.getBatchPayments().add(new BatchPayment());
		state.getBatchPayments().add(new BatchPayment());
		state.getBatchPayments().add(new BatchPayment());
		state.getBatchPayments().add(new BatchPayment());
		
		// Add the variable, not sure if needed.		
		execution.setVariable("state", state);
		


		
		Utils.Log.info("Created Instructions");
	}

}
