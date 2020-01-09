package com.dendoc.registration.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.dendoc.registration.enums.CommonEnums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel
public class Users {

	@Id
	@GeneratedValue
	private long userId;
	
	@ApiModelProperty(name="loginName",value="loginNameValue",example="CosmoApp")
	private String loginName;
	
	@ApiModelProperty(name="password",value="passwordValue",example="test@1234")
	private String loginPassword;
	
    @Enumerated(EnumType.ORDINAL)
    @ApiModelProperty(name="userType",value="userTypeValue",example="provider")
    private CommonEnums.UserTypes userType;
    
    @Enumerated(EnumType.ORDINAL)
	private CommonEnums.LoginTypes loginType;
	
	public Users() {
		super();
	}

	public Users(long userId, String loginName, String loginPassword, CommonEnums.UserTypes userType, CommonEnums.LoginTypes loginType) {
		super();
		this.userId = userId;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.userType = userType;
		this.loginType = loginType;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getloginPassword() {
		return loginPassword;
	}

	public void setloginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public CommonEnums.UserTypes getUserType() {
		return this.userType;
	}

	public void setUserType(CommonEnums.UserTypes userType) {
		this.userType = userType;
	}

	public CommonEnums.LoginTypes getLoginType() {
		return loginType;
	}

	public void setLoginType(CommonEnums.LoginTypes loginType) {
		this.loginType = loginType;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", loginName=" + loginName + ", loginPassword=" + loginPassword + ", userType="
				+ userType + ", loginType=" + loginType + "]";
	}

}
