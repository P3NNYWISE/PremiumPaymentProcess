package com.northstarlife.servicing;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;



import com.northstar.slxclient.client.api.PremiumRequestsApi;
import com.northstar.slxclient.client.model.PremiumRequestBatch;
import com.northstar.slxclient.client.model.PremiumRequest;

import com.northstar.slxclient.client.base.ApiException;

import com.northstarlife.Utils;

public class ValidateInstructionsListener implements ExecutionListener 
{
    public void notify(DelegateExecution execution) throws Exception {
    	
		// CreateBatchPayment objects
		PremiumRequestProcessState state = (PremiumRequestProcessState) execution.getVariable("state");
		
	  	Utils.Log.info(">>>>> Validate Instructions Execution Listener created : " + state.getApproved());
    }
}