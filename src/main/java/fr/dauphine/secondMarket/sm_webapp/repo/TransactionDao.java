/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.Transaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;

/**
 * @author gnepa.rene.barou
 *
 */
public interface TransactionDao {
	
	Transaction findById(Long id) throws SmDaoException;

	List<Transaction> findAllOrderedByDate() throws SmDaoException; 
	
	List<Transaction> findAllActifOrderedByDate() throws SmDaoException;
	
	List<Transaction> findByTitre(Long idTitre) throws SmDaoException;
	
	List<Transaction> findBySociete(Long idSociete) throws SmDaoException;
	
	List<Transaction> findByAcheteur(Long idAcheteur) throws SmDaoException;
	
	List<Transaction> findByVendeur(Long idVendeur) throws SmDaoException;

	List<Transaction> search(String fullText ) throws SmDaoException;
	
	void register(Transaction transaction) throws SmDaoException;

	void delete(Transaction transaction) throws SmDaoException;

	void update(Transaction transaction) throws SmDaoException; 
}
