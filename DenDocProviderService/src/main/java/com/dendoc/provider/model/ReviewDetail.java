/**
 * 
 */
package com.dendoc.provider.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Chetan
 *
 */
@Entity
@Table(name = "REVIEWDETAIL")
public class ReviewDetail implements Serializable{

	private static final long serialversionUID = 129348938L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REVIEW_ID")
	private long ReviewId;
	
	@ApiModelProperty(name = "rating", value = "ratingValue", example = "4")
	@Column(name = "RATING")
	private long rating;
	
	@NotBlank(message = "reviewTitle should not be empty")
	@ApiModelProperty(name = "reviewTitle", value = "reviewTitleValue", example = "Good service")
	@Column(name = "REVIEW_TITLE")
	private String reviewTitle;
	
	@NotBlank(message = "reviewDesc should not be empty")
	@ApiModelProperty(name = "reviewDesc", value = "reviewDescValue", example = "Good Doctor and service , caring is good")
	@Column(name = "REVIEW_DESC")
	private String reviewDesc;
	
	@Past
	@ApiModelProperty(name = "updatedDate", value = "updatedDateValue", example = "14/01/2020")
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	
	@ApiModelProperty(name = "clientId", value = "clientIdValue", example = "4")
	@Column(name = "CLIENT_ID")
	private long clientId;
	
	@ApiModelProperty(name = "providerId", value = "providerIdValue", example = "4")
	@Column(name = "PROVIDER_ID")
	private long providerId;

	public long getReviewId() {
		return ReviewId;
	}

	public void setReviewId(long reviewId) {
		ReviewId = reviewId;
	}

	public long getRating() {
		return rating;
	}

	public void setRating(long rating) {
		this.rating = rating;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewDesc() {
		return reviewDesc;
	}

	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}

	public static long getSerialversionuid() {
		return serialversionUID;
	}

	@Override
	public String toString() {
		return "ReviewDetail [ReviewId=" + ReviewId + ", rating=" + rating + ", reviewTitle=" + reviewTitle
				+ ", reviewDesc=" + reviewDesc + ", updatedDate=" + updatedDate + ", clientId=" + clientId
				+ ", providerId=" + providerId + "]";
	}
		
}
