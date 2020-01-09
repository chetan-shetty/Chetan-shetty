package com.dendoc.login.enums;

public class CommonEnums {

	public enum UserTypes{
		PROVIDERS (0)  , CLIENTS (1);
		
	    private int code ;

	    private UserTypes(int code) {
	        this.code = code;
	    }
	    public int getCode() {
	        return code;
	    }
	    public static UserTypes getUserTypesFromCode(int code){
	        for(UserTypes e : UserTypes.values()){
	            if(code == e.code) return e;
	        }
	        return UserTypes.PROVIDERS; //or null
	    }
		
	}
	
	public enum LoginTypes{
		PASSWORD(0) , GMAIL(1) , FACEBOOK(2);
	    private int code ;

	    private LoginTypes(int code) {
	        this.code = code;
	    }
	    public int getCode() {
	        return code;
	    }
	    public static LoginTypes getLoginTypesFromCode(int code){
	        for(LoginTypes e : LoginTypes.values()){
	            if(code == e.code) return e;
	        }
	        return LoginTypes.PASSWORD; //or null
	    }
	}
}
