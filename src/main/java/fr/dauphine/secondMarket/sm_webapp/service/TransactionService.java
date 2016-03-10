/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service;

import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;

/**
 * @author gnepa.rene.barou
 *
 */
public interface TransactionService {

	void create(Long idContrat, final Long idInvestisseur, final Long prixInitial, final Long prixFinal, String etat) throws SmDaoException;
}
