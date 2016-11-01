package com.northstarlife.servicing;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;


import com.northstar.slxclient.client.api.PoliciesApi;
import com.northstar.slxclient.client.model.PolicyPremium;
import com.northstar.slxclient.client.model.PremiumRequestPolicy ;


import com.northstar.slxclient.client.model.PremiumRequestBatch;
import com.northstar.slxclient.client.base.ApiException;
import com.northstar.slxclient.client.model.Policy ;




import com.northstarlife.Utils;

public class ConfirmBatchPaymentTaskListener implements TaskListener {
	
	  public void notify(DelegateTask delegateTask) {
		    // Custom logic goes here

	  		PremiumRequestProcessState state = (PremiumRequestProcessState) delegateTask.getVariable("state");
			PremiumRequestBatch batch = (PremiumRequestBatch) delegateTask.getVariable("batch");

			Utils.Log.info(">>> policies task" + state.getPolicy() );

			/**
			**Update Policy Premium
			*/
	    	PoliciesApi apiInstance = new PoliciesApi();
	    	apiInstance.getApiClient().setBasePath("http://zsqbkee7tah5mmf4a-mock.stoplight-proxy.io/slx-api/v1");
			
			String premiumId = state.getRequest().getId();

			for (	Policy policy : state.getPolicy()  ) {
		
				Utils.Log.info(">>> to send" + policy);

				String id = policy.getId(); // String | 
				PolicyPremium body =  policy.getCurrentPremium(); //Build Body
				Utils.Log.info(">>> to send" + body);

				try {
				    PolicyPremium result = apiInstance.updatePolicyPremium(id, premiumId, body);
				    Utils.Log.info(">>> " + result);
				} catch (ApiException e) {
				    
				    Utils.Log.info(">>> Exception when calling PoliciesApi#updatePolicyPremium");
				    e.printStackTrace();
				}		
			}

			  	Utils.Log.info(">>> ConfirmBatchPaymentTaskListener Task Listener created");
	}

}