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

	void delete(int id) throws SmDaoException;

	List<Societe> findAll() throws SmDaoException;

	void update(Societe societeToUpdate) throws SmDaoException;

	Societe findById(int id) throws SmDaoException;

	void accredit(int id) throws SmDaoException;

}
