package com.dendoc.client.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Service {

	@Id
	@GeneratedValue
	private long serviceId;
	
	private String serviceName;
	private String serviceDetails;
	
	public Service() {
		super();
	}

	public Service(long serviceId, String serviceName, String serviceDetails) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceDetails = serviceDetails;
	}

	
	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDetails() {
		return serviceDetails;
	}

	public void setServiceDetails(String serviceDetails) {
		this.serviceDetails = serviceDetails;
	}

	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceName=" + serviceName + 
				", serviceDetails=" + serviceDetails + "]";
	}

}
