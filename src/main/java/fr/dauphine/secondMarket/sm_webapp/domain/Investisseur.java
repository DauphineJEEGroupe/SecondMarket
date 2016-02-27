/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author gnepa.rene.barou
 *
 */
@Entity
@DiscriminatorValue("INV")
public class Investisseur extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1556525409080897185L;

	/**
	 * 
	 */
	public Investisseur() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param email
	 * @param login
	 * @param pass
	 */
	public Investisseur(String email, String login, String pass) {
		super(email, login, pass);
		// TODO Auto-generated constructor stub
	}

	private String profilInvestisseur;

	/**
	 * @return the profilInvestisseur
	 */
	public String getProfilInvestisseur() {
		return profilInvestisseur;
	}

	/**
	 * @param profilInvestisseur
	 *            the profilInvestisseur to set
	 */
	public void setProfilInvestisseur(String profilInvestisseur) {
		this.profilInvestisseur = profilInvestisseur;
	}

}
