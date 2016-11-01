package com.northstarlife.servicing.carriercalls;

import java.util.ArrayList;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.northstar.slxclient.client.model.Carrier;
import com.northstar.slxclient.client.model.Policy;
import com.northstarlife.Utils;

public class RetrieveGroupedCarrierPoliciesService implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		
		// This should be an array of CarrierGroup entity, probably returned from API call
		// 
		//filter bay Carrier and Status Pending and sending to CarrierCallState
		Carrier currentCarrier =  new Carrier();
		currentCarrier.setId("2");
		currentCarrier.setName("Carrier 1");
		
		ArrayList<Policy> list = new ArrayList<Policy>();
		for (int i=1 ; i<=10 ; i++ ){
			Policy currentPolicy =  new Policy();
			currentPolicy.setId(String.valueOf(i));
			currentPolicy.setCarrier(currentCarrier);
			list.add(currentPolicy);
			
		}
		//API Call Retrieve policies per group


		execution.setVariable("policiesPerGroup", list);	
		Utils.Log.info(">>>>> Retrieve Grouped Listener created");
	}
}