package com.dendoc.client.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable{

	private static final long serialversionUID = 129348938L;
	@Id
	@Column(name = "CLIENT_ID")
	private long clientId;

	@NotBlank(message = "clientName should not be empty")
	@ApiModelProperty(name = "clientName", value = "clientNameValue", example = "Robert Watson")
	@Column(name = "CLIENT_NAME")
	private String clientName;

	@Pattern(regexp = "(\\+61|0)[0-9]{10}")
	@ApiModelProperty(name = "phoneNumber", value = "phoneNumberValue", example = "+616012696156")
	@Column(name = "PHONENUMBER")
	private String phoneNumber;

	 @Pattern(flags = { Pattern.Flag.CASE_INSENSITIVE }, 
			 regexp = "[a-zA-Z0-9_.-]+[@][a-zA-Z]+([.][a-zA-Z]+)+", message = "Email not in validate formate")
	@ApiModelProperty(name = "email", value = "emailValue", example = "robert.watson@gmail.com")
	@Column(name = "EMAIL")
	private String email;

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
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

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + "]";
	}
	 
}
