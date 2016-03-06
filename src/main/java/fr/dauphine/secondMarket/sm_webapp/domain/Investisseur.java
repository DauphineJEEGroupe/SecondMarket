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
