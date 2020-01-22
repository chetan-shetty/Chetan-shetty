package com.dendoc.provider.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "PROVIDER")
public class Provider {

	@Id
	@Column(name = "PROVIDER_ID")
	private long providerId;

	@NotBlank(message = "providerName should not be empty")
	@ApiModelProperty(name = "providerName", value = "providerNameValue", example = "Robert Watson")
	@Column(name = "PROVIDER_NAME")
	private String providerName;
	
	@NotBlank(message = "providerSpecialization should not be empty")
	@ApiModelProperty(name = "providerSpecialization", value = "providerSpecializationValue", example = "Dental Surgeon")
	@Column(name = "PROVIDER_SPECIALIZATION")
	private String providerSpecialization ;

	@Pattern(regexp = "(\\+61|0)[0-9]{10}", message = "Phone number is not in validate formate")
	@ApiModelProperty(name = "phoneNumber", value = "phoneNumberValue", example = "+616012696156")
	@Column(name = "PHONENUMBER")
	private String phoneNumber;

	 @Pattern(flags = { Pattern.Flag.CASE_INSENSITIVE }, 
			 regexp = "[a-zA-Z0-9_.-]+[@][a-zA-Z]+([.][a-zA-Z]+)+", message = "Email not in validate formate")
	@ApiModelProperty(name = "email", value = "emailValue", example = "robert.watson@gmail.com")
	@Column(name = "EMAIL")
	private String email;

	@ApiModelProperty(name = "status", value = "statusValue", example = "A")
	@Column(name = "STATUS" , columnDefinition = "")
	private String status = "A";

	@ApiModelProperty(name = "rating", value = "ratingValue", example = "4.1")
	@Column(name = "RATING")
	private double rating = 0.0 ;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;

	
	  @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
	  CascadeType.MERGE })
	  
	  @JoinTable(name = "provider_insurance", joinColumns = { @JoinColumn(name =
	  "insurance_id") }, inverseJoinColumns = {
	  
	  @JoinColumn(name = "provider_id") })
	  
	  @OnDelete(action = OnDeleteAction.CASCADE) 
	  private Set<Insurance> insurance =  new HashSet<Insurance>();
	  
	  @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
	  CascadeType.MERGE })
	  
	  @JoinTable(name = "provider_service", joinColumns = { @JoinColumn(name =
	  "service_id") }, inverseJoinColumns = {
	  
	  @JoinColumn(name = "provider_id") })
	  
	  @OnDelete(action = OnDeleteAction.CASCADE) 
	  private Set<Service> services =  new HashSet<Service>();
	 

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
	
	  public String getProviderSpecialization() {
		return providerSpecialization;
	}

	public void setProviderSpecialization(String providerSpecialization) {
		this.providerSpecialization = providerSpecialization;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Set<Insurance> getInsurance() { return insurance; }
	  
	  public void setInsurance(Set<Insurance> insurance) { this.insurance =
	  insurance; }
	  
	  public Set<Service> getServices() { return services; }
	  
	  public void setServices(Set<Service> services) { this.services = services; }

	@Override
	public String toString() {
		return "Provider [providerId=" + providerId + ", providerName=" + providerName + ", providerSpecialization="
				+ providerSpecialization + ", phoneNumber=" + phoneNumber + ", email=" + email + ", status=" + status
				+ ", rating=" + rating + ", address=" + address + ", insurance=" + insurance + ", services=" + services
				+ "]";
	}
	 
}
