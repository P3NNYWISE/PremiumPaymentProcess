package com.northstarlife.servicing.carriercalls;

import java.util.ArrayList;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class RetrieveGroupedCarrierPoliciesService implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		
		// This should be an array of CarrierGroup entity, probably returned from API call
		ArrayList<String> list = new ArrayList<String>();
		list.add("Group1");
		list.add("Group2");
		list.add("Group3");
		list.add("Group4");
		
		execution.setVariable("policiesPerGroup", list);		
	}
}