/**
 * 
 */
package com.dendoc.registration.model;

/**
 * @author Chetan
 *
 */
public class UserProvider {

	/**
	 * 
	 */
	private Users users ;
	
	private Provider provider;
	
	
	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserProvider [users=" + users + ", provider=" + provider + "]";
	}

}
