package com.northstarlife.servicing;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;


import com.northstar.slxclient.client.api.PoliciesApi;
import com.northstar.slxclient.client.model.PolicyPremium;
import com.northstar.slxclient.client.model.PremiumRequestPolicy ;


import com.northstar.slxclient.client.model.PremiumRequestBatch;
import com.northstar.slxclient.client.base.ApiException;
import com.northstar.slxclient.client.model.Policy ;


import com.northstarlife.Utils;

public class ConfirmBatchPaymentListener implements ExecutionListener 
{
    public void notify(DelegateExecution execution) throws Exception {
    	    	//Process Variable 
		PremiumRequestProcessState state = (PremiumRequestProcessState) execution.getVariable("state");
		PremiumRequestBatch batch = (PremiumRequestBatch) execution.getVariable("batch");


    }
}