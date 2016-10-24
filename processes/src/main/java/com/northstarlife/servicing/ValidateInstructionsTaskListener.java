package com.northstarlife.servicing;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

import com.northstarlife.Utils;

public class ValidateInstructionsTaskListener implements TaskListener {
	
	  public void notify(DelegateTask delegateTask) {
		    // Custom logic goes here
		  	Utils.Log.info(">>>>> Validate Instructions Task Listener created");
		  }

}
