/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.Contrat;
import fr.dauphine.secondMarket.sm_webapp.domain.Transaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;

/**
 * @author gnepa.rene.barou
 *
 */
public interface TransactionService {

	void create(Transaction transaction) throws SmDaoException;
	
	List<Transaction> findAll() throws SmDaoException;
	
	List<Transaction> findAllTransactionActif() throws SmDaoException;

	Transaction findById(Long id) throws SmDaoException;

	List<Transaction> findByAcheteur(Long idAcheteur) throws SmDaoException;
	
	List<Transaction> findByVendeur(Long idVendeur) throws SmDaoException;
	
	List<Transaction> findByTitre(Long idTitre) throws SmDaoException;
	
	Contrat findByTitreForSale(Long idTitre) throws SmDaoException;
	
	List<Transaction> findBySociete(Long idSociete) throws SmDaoException;

	void update(Transaction transactionToUpdate) throws SmDaoException;

	
	void delete(Long id) throws SmDaoException;
}
