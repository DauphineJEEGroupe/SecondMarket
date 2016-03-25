/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.Contrat;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmTechException;

/**
 * @author gnepa.rene.barou
 *
 */
public interface ContratService {

	void create(Contrat newContrat)
			throws SmDaoException, SmTechException;

	void delete(Long id) throws SmDaoException;

	List<Contrat> findAll() throws SmDaoException;

	List<Contrat> findByInvestisseur(Long idInvestisseur) throws SmDaoException;

	void update(Contrat contratToUpdate) throws SmDaoException;

	Contrat findById(Long id) throws SmDaoException;
}
