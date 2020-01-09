package com.dendoc.provider.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel
@Table(name = "service")
public class Service {

	@Id
	@GeneratedValue
	private long serviceId;
	
	@ApiModelProperty(name="serviceName",value="serviceNameValue",example="Cosmetic")
	private String serviceName;
	
	@ApiModelProperty(name="serviceDetails",value="serviceDetailsValue",example="Cosmetic")
	private String serviceDetails;
	
	 @ManyToMany(
		 		fetch = FetchType.LAZY, 
		 		cascade = {CascadeType.PERSIST, CascadeType.MERGE },
		 		mappedBy = "insurance"
		 	)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 private Set<Provider> providers = new HashSet<Provider>();
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
		return "Service [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceDetails=" + serviceDetails
				+ ", providers=" + providers + "]";
	}

}
