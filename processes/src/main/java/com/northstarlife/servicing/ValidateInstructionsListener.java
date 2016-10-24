package com.northstarlife.servicing;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import com.northstarlife.Utils;

public class ValidateInstructionsListener implements ExecutionListener 
{
    public void notify(DelegateExecution execution) throws Exception {
    	
		// CreateBatchPayment objects
		PremiumRequestProcessState state = (PremiumRequestProcessState) execution.getVariable("state");

		// Here we can get the variables from the step and apply to the object if the form did not already directly updated it.
		//Form Update state.approved
		
	  	Utils.Log.info(">>>>> Validate Instructions Execution Listener created : 	" + state.getApproved());
    }
}