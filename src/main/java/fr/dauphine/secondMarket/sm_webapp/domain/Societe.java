package fr.dauphine.secondMarket.sm_webapp.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Statut
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "siren"))
public class Societe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	private String nom;

	@NotNull
	@Size(min = 1, max = 25)
	private String siren;

	@NotNull
	@Size(min = 1, max = 25)
	private String ville;

	@NotNull
	@Size(min = 1, max = 25)
	private String pays;

	@ManyToOne
	private Statut statut;

	@OneToOne
	private MembreSociete representant;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the siren
	 */
	public String getSiren() {
		return siren;
	}

	/**
	 * @param siren
	 *            the siren to set
	 */
	public void setSiren(String siren) {
		this.siren = siren;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville
	 *            the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * @param pays
	 *            the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * @return the statut
	 */
	public Statut getStatut() {
		return statut;
	}

	/**
	 * @param statut
	 *            the statut to set
	 */
	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public MembreSociete getRepresentant() {
		return representant;
	}

	public void setRepresentant(MembreSociete representant) {
		this.representant = representant;
	}

}
