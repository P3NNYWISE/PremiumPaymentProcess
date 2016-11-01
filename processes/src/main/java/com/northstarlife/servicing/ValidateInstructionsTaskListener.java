package com.northstarlife.servicing;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;


import com.northstar.slxclient.client.api.PremiumRequestsApi;
import com.northstar.slxclient.client.model.PremiumRequestBatch;
import com.northstar.slxclient.client.model.PremiumRequest;
	
import com.northstar.slxclient.client.base.ApiException;

import com.northstarlife.Utils;

public class ValidateInstructionsTaskListener implements TaskListener {
	
	  public void notify(DelegateTask delegateTask) {
		    // Custom logic goes here
	  		//Form Update state.approved

		// CreateBatchPayment objects
		PremiumRequestProcessState state = (PremiumRequestProcessState) delegateTask.getVariable("state");

		PremiumRequestsApi apiInstance = new PremiumRequestsApi();
		apiInstance.getApiClient().setBasePath("http://zsqbkee7tah5mmf4a-mock.stoplight-proxy.io/slx-api/v1");
	
		PremiumRequest request = state.getRequest(); 
		state.setPaymentAgentId("2");

		// Here we can get the variables from the step and apply to the object if the form did not already directly updated it.
		//Form Update state.approved 

/*		for (PremiumRequestBatch batch : state.getBatchPayments() ) {


  			
  			if (state.getApproved()) {
				body.setState(StateEnum.CONFIRMED) ;
			} else {
				body.setState(StateEnum.REJECTED) ;
			}
			
  			
			try {
	    		apiInstance.updatePremiumRequestBatch(id, batchId, body);
			} catch (ApiException e) {
    			Utils.Log.info(">>> Exception when calling PremiumRequestsApi#updatePremiumRequestBatch");
	    		e.printStackTrace();
			}
        	

		}


*/	

			Utils.Log.info(">>>>> batch Payments" + state.getBatchPayments());
		  	Utils.Log.info(">>>>> Validate Instructions Task Listener created");
		  }

}
