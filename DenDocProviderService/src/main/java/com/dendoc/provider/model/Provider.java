package com.dendoc.provider.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "provider")
public class Provider {

	@Id
	@GeneratedValue
	private long providerId;

	@NotBlank (message="providerName should not be empty")
	@ApiModelProperty(name="providerName",value="providerNameValue",example="Robert Watson")
	private String providerName;

	@Pattern(regexp = "(\\+61|0)[0-9]{10}")
	@ApiModelProperty(name="phoneNumber",value="phoneNumberValue",example="+61 601256")
	private String phoneNumber;

	@Email(message = "Email should be valid format")
	@ApiModelProperty(name="email",value="emailValue",example="robert.watson@gmail.com")
	private String email;

	@ApiModelProperty(name="status",value="statusValue",example="A")
	private String status;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "provider")
	private Address address;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "provider_insurance", joinColumns = { @JoinColumn(name = "insurance_id") }, inverseJoinColumns = {
			@JoinColumn(name = "provider_id") })
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Insurance> insurance = new HashSet<Insurance>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "provider_service", joinColumns = { @JoinColumn(name = "service_id") }, inverseJoinColumns = {
			@JoinColumn(name = "provider_id") })
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Service> services = new HashSet<Service>();

	public Provider() {
		super();
	}

	public Provider(long providerId, String providerName, String phoneNumber, String email, String status) {
		super();
		this.providerId = providerId;
		this.providerName = providerName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.status = status;
		// this.addressId = addressId;
	}

	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(Set<Insurance> insurance) {
		this.insurance = insurance;
	}

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Provider [providerId=" + providerId + ", providerName=" + providerName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", status=" + status + ", address=" + address + ", insurance=" + insurance
				+ ", services=" + services + "]";
	}

}
