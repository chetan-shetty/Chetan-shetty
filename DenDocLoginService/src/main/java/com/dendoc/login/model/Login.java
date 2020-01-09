package com.dendoc.login.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Login {

	@ApiModelProperty(name="loginName",value="loginNameValue",example="CosmoApp")
	private String loginName;
	
	@ApiModelProperty(name="password",value="passwordValue",example="test@1234")
	private String password;

	public Login() {
		super();
	}

	public Login(String loginName, String password) {
		super();
		this.loginName = loginName;
		this.password = password;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [loginName=" + loginName + "]";
	}

}
