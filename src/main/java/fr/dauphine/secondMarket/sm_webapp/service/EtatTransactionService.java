/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.EtatTransaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;

/**
 * @author gnepa.rene.barou
 *
 */
public interface EtatTransactionService {
	EtatTransaction findById(Long id) throws SmDaoException;

	EtatTransaction findByCode(String code) throws SmDaoException;

	List<EtatTransaction> findAllOrderedByCode() throws SmDaoException;

	void register(EtatTransaction etatTransaction) throws SmDaoException;
}
