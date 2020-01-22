package com.dendoc.provider.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@Column(name = "ADDRESS_ID")
	private long addressId;
	
	@ApiModelProperty(name="pincode",value="pincodeValue",example="6027")
	@Column(name = "PINCODE")
	private long pincode;
	
	@ApiModelProperty(name="address",value="addressValue",example="Upstairs Suite 1/126 Grand Boulevard")
	@Column(name = "ADDRESS")
	private String address;

	@ApiModelProperty(name="state",value="stateValue",example="Joondalup WA")
	@Column(name = "STATE")
	private String state ;

	@ApiModelProperty(name="country",value="countryValue",example="Australia")
	@Column(name = "COUNTRY")
	private String country ;
	
	/*
	 * @Column(name = "PROVIDER_ID_FK") private long pIdFk;
	 */
	 
	
	/*
	 * @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional =
	 * false)
	 * 
	 * @JoinColumn(name = "PROVIDER_ID") private Provider provider;
	 */
		
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
