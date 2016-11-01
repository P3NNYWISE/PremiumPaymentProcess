package com.northstarlife.servicing.carriercalls;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


import com.northstar.slxclient.client.model.Carrier ;
import com.northstar.slxclient.client.model.PremiumRequestPolicy ;
import com.northstar.slxclient.client.model.Policy ;



public class CarrierCallState implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Carrier carrier = new Carrier();

	private Collection<PremiumRequestPolicy> premiumRequestPolicies = new ArrayList<PremiumRequestPolicy>();

	private Collection<Policy> policies = new ArrayList<Policy>();

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public Collection<PremiumRequestPolicy> getPremiumRequestPolicies() {
		return premiumRequestPolicies;
	}

	public void setPremiumRequestPolicies(Collection<PremiumRequestPolicy> premiumRequestPolicies) {
		this.premiumRequestPolicies = premiumRequestPolicies;
	}


	public Collection<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(Collection<Policy> policies) {
		this.policies = policies;
	}


}
