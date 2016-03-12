/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author gnepa.rene.barou
 *
 */
@Entity
public class Transaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3795215739291595084L;


	@Id
	@GeneratedValue
	private Integer id;
	
	
	private Long prixOuverture;
	private Long prixCloture;
	private Long prixTransaction;
	private Date dateDebut;
	private Date dateCloture;
	private int quantite;
	
	
	@ManyToOne
	private Contrat titre;
	
	@ManyToOne
	private TypeTransaction typeTransaction;

	@ManyToOne
	private EtatTransaction etatTransaction;

	@ManyToOne
	private ModeNegociation modeNegociation;
	
	@ManyToOne
	private Investisseur acheteur;
	
	@ManyToOne
	private Investisseur vendeur;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the prixOuverture
	 */
	public Long getPrixOuverture() {
		return prixOuverture;
	}

	/**
	 * @param prixOuverture the prixOuverture to set
	 */
	public void setPrixOuverture(Long prixOuverture) {
		this.prixOuverture = prixOuverture;
	}

	/**
	 * @return the prixCloture
	 */
	public Long getPrixCloture() {
		return prixCloture;
	}

	/**
	 * @param prixCloture the prixCloture to set
	 */
	public void setPrixCloture(Long prixCloture) {
		this.prixCloture = prixCloture;
	}

	/**
	 * @return the prixTransaction
	 */
	public Long getPrixTransaction() {
		return prixTransaction;
	}

	/**
	 * @param prixTransaction the prixTransaction to set
	 */
	public void setPrixTransaction(Long prixTransaction) {
		this.prixTransaction = prixTransaction;
	}

	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateCloture
	 */
	public Date getDateCloture() {
		return dateCloture;
	}

	/**
	 * @param dateCloture the dateCloture to set
	 */
	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
	}

	/**
	 * @return the titre
	 */
	public Contrat getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(Contrat titre) {
		this.titre = titre;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the typeTransaction
	 */
	public TypeTransaction getTypeTransaction() {
		return typeTransaction;
	}

	/**
	 * @param typeTransaction the typeTransaction to set
	 */
	public void setTypeTransaction(TypeTransaction typeTransaction) {
		this.typeTransaction = typeTransaction;
	}

	/**
	 * @return the etatTransaction
	 */
	public EtatTransaction getEtatTransaction() {
		return etatTransaction;
	}

	/**
	 * @param etatTransaction the etatTransaction to set
	 */
	public void setEtatTransaction(EtatTransaction etatTransaction) {
		this.etatTransaction = etatTransaction;
	}

	/**
	 * @return the modeNegociation
	 */
	public ModeNegociation getModeNegociation() {
		return modeNegociation;
	}

	/**
	 * @param modeNegociation the modeNegociation to set
	 */
	public void setModeNegociation(ModeNegociation modeNegociation) {
		this.modeNegociation = modeNegociation;
	}

	/**
	 * @return the acheteur
	 */
	public Investisseur getAcheteur() {
		return acheteur;
	}

	/**
	 * @param acheteur the acheteur to set
	 */
	public void setAcheteur(Investisseur acheteur) {
		this.acheteur = acheteur;
	}

	/**
	 * @return the vendeur
	 */
	public Investisseur getVendeur() {
		return vendeur;
	}

	/**
	 * @param vendeur the vendeur to set
	 */
	public void setVendeur(Investisseur vendeur) {
		this.vendeur = vendeur;
	}

}
