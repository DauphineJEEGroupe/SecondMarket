/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.Societe;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmTechException;

/**
 * @author gnepa.rene.barou
 *
 */
public interface SocieteService {
	
	void create(Societe newSociete) throws SmDaoException, SmTechException;

	void delete(Long id) throws SmDaoException;

	List<Societe> findAll() throws SmDaoException;
	
	List<Societe> search(String fullText) throws SmDaoException;

	void update(Societe societeToUpdate) throws SmDaoException;

	Societe findById(Long id) throws SmDaoException;

	void accredit(Long id) throws SmDaoException;

}
