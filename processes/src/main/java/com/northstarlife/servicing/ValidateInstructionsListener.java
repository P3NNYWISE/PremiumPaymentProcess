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
		
		
	  	Utils.Log.info(">>>>> Validate Instructions Execution Listener created : " + state.getApproved());
    }
}