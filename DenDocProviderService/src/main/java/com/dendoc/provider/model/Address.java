package com.dendoc.provider.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table (name = "address")
public class Address implements Serializable {

	@Id
	@GeneratedValue
	private long addressId;
	
	@ApiModelProperty(name="pincode",value="pincodeValue",example="6027")
	private long pincode;
	
	@ApiModelProperty(name="address",value="addressValue",example="Upstairs Suite 1/126 Grand Boulevard")
	private String address;

	@ApiModelProperty(name="state",value="stateValue",example="Joondalup WA")
	private String state ;

	@ApiModelProperty(name="country",value="countryValue",example="Australia")
	private String country ;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "provider_id", nullable = false)
	private Provider provider;
		
	public Address() {
		super();
	}

	public Address(long addressId, long pincode, String address, String state, String country) {
		super();
		this.addressId = addressId;
		this.pincode = pincode;
		this.address = address;
		this.state = state;
		this.country = country;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", pincode=" + pincode + ", address=" + address + ", state=" + state
				+ ", country=" + country + "]";
	}
	
		
}
