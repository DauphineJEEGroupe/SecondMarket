package fr.dauphine.secondMarket.sm_webapp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EMP")
public class Employer extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5200276127055526415L;
	
	private String emploi;

	public String getEmploi() {
		return emploi;
	}

	public void setEmploi(String titre) {
		this.emploi = titre;
	}

}
