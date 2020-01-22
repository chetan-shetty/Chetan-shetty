/**
 * 
 */
package com.dendoc.provider.model;

/**
 * @author Chetan
 *
 */
public class UserProvider {

	/**
	 * 
	 */
	private Provider provider;
	
	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "UserProvider [provider=" + provider + "]";
	}

}
