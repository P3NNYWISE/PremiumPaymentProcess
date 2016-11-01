package com.northstarlife.servicing.carriercalls;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import com.northstarlife.Utils;

public class LoadedNewValuesListener implements ExecutionListener 
{
    public void notify(DelegateExecution execution) throws Exception {
    	
	  	Utils.Log.info(">>>>> Loaded New Values Listener created");
    }
}