package fr.dauphine.secondMarket.sm_webapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	/**
	 * @param email
	 * @param login
	 * @param pass
	 */
	public User(String email, String login, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(name = "email", nullable = false, length = 20)
	private String email;

	@Column(name = "motdepasse", nullable = false, length = 20)
	private String pass;

	@Column(name = "nom", length = 20)
	private String nom;

	@Column(name = "prenom", length = 20)
	private String prenom;

	@Column(name = "role", nullable = false, length = 2)
	private int role;

	private Boolean actif;


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", email=");
		builder.append(email);
		builder.append(", login=");
		builder.append(", pass=");
		builder.append(pass);
		builder.append("]");
		return builder.toString();
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the actif
	 */
	public Boolean getActif() {
		return actif;
	}

	/**
	 * @param actif
	 *            the actif to set
	 */
	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}

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

}