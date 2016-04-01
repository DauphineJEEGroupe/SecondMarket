package fr.dauphine.secondMarket.sm_webapp.mvc.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.dauphine.secondMarket.sm_webapp.utils.Constantes;

@Component
@Scope(value = "session")
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4089290088450930030L;

	private String username;
	
	private String email;
	
	private long id;
	
	private String typeUser;
	
	private String phoneNumber;
	
	private String password;

	private String role;

	private boolean isConneted;
	
	private boolean isAdmin;

	public UserBean() {
	}

	public void reinitialiser() {
		this.username = null;
		this.email = null;
		this.password = null;
		this.role = null;
		this.isConneted = false;
		this.setAdmin(false);

	}
	
	public void logout() {
		reinitialiser();
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
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
	 * @param email
	 *            the email to set
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
	 * @param password
	 *            the password to set
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
	 * @param role
	 *            the role to set
	 */
	public void setRole(final String role) {
		this.role = role;
		if(Constantes.ROLE_ADMIN.equals(getRole())){
			this.setAdmin(true);
		}else{
			this.setAdmin(false);
		}
	}

	/**
	 * @return the isConneted
	 */
	public boolean isConneted() {
		return isConneted;
	}

	/**
	 * @param isConneted
	 *            the isConneted to set
	 */
	public void setConneted( boolean isConneted) {
		this.isConneted = isConneted;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the typeUser
	 */
	public String getTypeUser() {
		return typeUser;
	}

	/**
	 * @param typeUser
	 *            the typeUser to set
	 */
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setAdmin(boolean isAdmin) {
//		this.isAdmin = isAdmin;
	}

}
