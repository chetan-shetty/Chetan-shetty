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
@Table(name = "insurance")
public class Insurance {

	@Id
	@GeneratedValue
	private long insuranceId;
	
	@ApiModelProperty(name="insuranceName",value="insuranceNameValue",example="MEDICARE")
	private String insuranceName;
	
	@ApiModelProperty(name="insuranceDetails",value="insuranceDetailsValue",example="MEDICARE")
	private String insuranceDetails;
	
	@ManyToMany(
	 		fetch = FetchType.LAZY, 
	 		cascade = {CascadeType.PERSIST, CascadeType.MERGE },
	 		mappedBy = "insurance"
	 	)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Provider> providers = new HashSet<Provider>();
	
	public Insurance() {
		super();
	}
	
	public Insurance(long insuranceId, String insuranceName, String insuranceDetails) {
		super();
		this.insuranceId = insuranceId;
		this.insuranceName = insuranceName;
		this.insuranceDetails = insuranceDetails;
	}

	public long getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(long insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public String getInsuranceDetails() {
		return insuranceDetails;
	}

	public void setInsuranceDetails(String insuranceDetails) {
		this.insuranceDetails = insuranceDetails;
	}

	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", insuranceName=" + insuranceName + ", insuranceDetails="
				+ insuranceDetails + ", providers=" + providers + "]";
	}

}
