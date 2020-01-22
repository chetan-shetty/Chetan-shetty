/**
 * 
 */
package com.dendoc.registration.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Chetan
 *
 */
public class Provider {

	private long providerId;

	private String providerName;
	
	private String providerSpecialization ;

	private String phoneNumber;

	private String email;

	private String status = "A";

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

	public String getProviderSpecialization() {
		return providerSpecialization;
	}

	public void setProviderSpecialization(String providerSpecialization) {
		this.providerSpecialization = providerSpecialization;
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

	@Override
	public String toString() {
		return "Provider [providerId=" + providerId + ", providerName=" + providerName + ", providerSpecialization="
				+ providerSpecialization + ", phoneNumber=" + phoneNumber + ", email=" + email + ", status=" + status
				+ "]";
	}

	
}
