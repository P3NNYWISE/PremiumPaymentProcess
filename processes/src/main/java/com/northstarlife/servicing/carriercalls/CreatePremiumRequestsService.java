package com.northstarlife.servicing.carriercalls;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


import com.northstarlife.Utils;

public class CreatePremiumRequestsService implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
			Utils.Log.info(">>>>> Create Premium Request Service Listener created");
	}

}