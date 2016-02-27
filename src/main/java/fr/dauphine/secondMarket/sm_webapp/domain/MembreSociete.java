/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author gnepa.rene.barou
 *
 */
@Entity
@DiscriminatorValue("MS")	
public class MembreSociete extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2256736361922373920L;

	/**
	 * 
	 */
	public MembreSociete() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param email
	 * @param login
	 * @param pass
	 */
	public MembreSociete(String email, String login, String pass) {
		super(email, login, pass);
		// TODO Auto-generated constructor stub
	}
	
	@OneToOne
	private Societe societe;

	/**
	 * @return the societe
	 */
	public Societe getSociete() {
		return societe;
	}

	/**
	 * @param societe the societe to set
	 */
	public void setSociete(Societe societe) {
		this.societe = societe;
	}

}
