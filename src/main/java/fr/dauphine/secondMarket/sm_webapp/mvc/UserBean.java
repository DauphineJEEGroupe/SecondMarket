package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4089290088450930030L;
	
	/** The username. */
    private String username;
    
    private String email;

    /** The password. */
    private String password;
    
    private String role;
    
    private boolean isConneted;
    

	public UserBean() {
	}
	
	public void reinitialiser()
	{
		this.username=null;
		this.email=null;
		this.password=null;
		this.role=null;
		this.isConneted=false;
		
	}
	
	public void logout(){
		isConneted=false;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(final String role) {
		this.role = role;
	}

	/**
	 * @return the isConneted
	 */
	public boolean isConneted() {
		return isConneted;
	}

	/**
	 * @param isConneted the isConneted to set
	 */
	public void setConneted(final boolean isConneted) {
		this.isConneted = isConneted;
	}

}
