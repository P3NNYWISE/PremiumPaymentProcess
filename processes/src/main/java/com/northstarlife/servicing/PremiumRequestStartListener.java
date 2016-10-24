package com.northstarlife.servicing;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import com.northstarlife.Utils;

public class PremiumRequestStartListener implements ExecutionListener 
{
    public void notify(DelegateExecution execution) throws Exception {
    	// The initial state will be created by the form
    	// We can read it here already an do stuff!
    	
		// CreateBatchPayment objects
		PremiumRequestProcessState state = (PremiumRequestProcessState) execution.getVariable("state");
	
		
    	Utils.Log.info("State created");
    }
}