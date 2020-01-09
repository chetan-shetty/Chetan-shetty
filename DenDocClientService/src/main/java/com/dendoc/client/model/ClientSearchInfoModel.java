package com.dendoc.client.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ClientSearchInfoModel {
	@ApiModelProperty(name="servicesList",value="servicesListValue",example="List of services")
	List<Service> servicesList;
	
	@ApiModelProperty(name="insurancesList",value="insurancesListValue",example="List of Insurance")
	List<Insurance> insurancesList;
	
	public List<Service> getServicesList() {
		return servicesList;
	}
	public void setServicesList(List<Service> servicesList) {
		this.servicesList = servicesList;
	}
	public List<Insurance> getInsurancesList() {
		return insurancesList;
	}
	public void setInsurancesList(List<Insurance> insurancesList) {
		this.insurancesList = insurancesList;
	}
	
	@Override
	public String toString() {
		return "ClientSearchInfoModel [servicesList=" + servicesList + ", insurancesList=" + insurancesList + "]";
	}
}
