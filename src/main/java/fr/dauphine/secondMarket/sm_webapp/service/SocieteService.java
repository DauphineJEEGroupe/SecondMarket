/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.Societe;

/**
 * @author gnepa.rene.barou
 *
 */
public interface SocieteService {
	public Societe create(Societe societe);
	public Societe delete(Long id) ;
	public List<Societe> findAll();
	public Societe update(Societe societe) ;
	public Societe findById(Long id);

}
