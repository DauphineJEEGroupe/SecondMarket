package fr.dauphine.secondMarket.sm_webapp.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "codeIsin"))
public class Contrat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 984415866120244549L;
	
	@Id
//	@GeneratedValue
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 25)
	private String  codeIsin;
	
	
	private long valeur;
	
	@ManyToOne
	private TypeContrat typeContrat;
	
	@ManyToOne
	private Investisseur proprietaire;
	
	@ManyToOne
	private Societe societe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeIsin() {
		return codeIsin;
	}

	public void setCodeIsin(String codeIsin) {
		this.codeIsin = codeIsin;
	}

	public long getValeur() {
		return valeur;
	}

	public void setValeur(long valeur) {
		this.valeur = valeur;
	}

	public TypeContrat getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}

	public Investisseur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Investisseur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

}
