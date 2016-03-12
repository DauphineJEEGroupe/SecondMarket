package fr.dauphine.secondMarket.sm_webapp.domain;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Statut
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class Statut implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1822754709531299097L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	private String code;

	public Statut() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String nom) {
		this.code = nom;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Statut [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append("]");
		return builder.toString();
	}

}
