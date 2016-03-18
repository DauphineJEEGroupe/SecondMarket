/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.Transaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;

/**
 * @author gnepa.rene.barou
 *
 */
public interface TransactionService {

	void create(Long idTransaction, final Long idInvestisseur, final Long prixInitial, final Long prixFinal, String etat) throws SmDaoException;
	List<Transaction> findTransactionActif();
	
	void delete(int id) throws SmDaoException;

	List<Transaction> findAll() throws SmDaoException;

	List<Transaction> findByInvestisseur(Long idInvestisseur) throws SmDaoException;

	void update(Transaction transactionToUpdate) throws SmDaoException;

	Transaction findById(int id) throws SmDaoException;
}
