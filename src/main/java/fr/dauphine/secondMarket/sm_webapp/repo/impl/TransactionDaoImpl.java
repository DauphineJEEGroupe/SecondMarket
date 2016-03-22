/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.secondMarket.sm_webapp.domain.Transaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.TransactionDao;

/**
 * @author gnepa.rene.barou
 *
 */
@Repository
@Transactional
public class TransactionDaoImpl implements TransactionDao {

	@Autowired
	private EntityManager em;
	private CriteriaBuilder builder;

	@PostConstruct
	private void init() {
		builder = em.getCriteriaBuilder();
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TransactionDao#findById(int)
	 */
	@Override
	public Transaction findById(int id) throws SmDaoException {
		try {
			return em.find(Transaction.class, id);
		} catch (IllegalArgumentException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TransactionDao#findAllOrderedByDate()
	 */
	@Override
	public List<Transaction> findAllOrderedByDate() throws SmDaoException {
		try {
			CriteriaQuery<Transaction> criteria = builder
					.createQuery(Transaction.class);
			Root<Transaction> transactionRoot = criteria.from(Transaction.class);

			criteria.select(transactionRoot).orderBy(
					builder.desc(transactionRoot.get("dateCloture")));
			return em.createQuery(criteria).getResultList();
		} catch (IllegalArgumentException | PersistenceException e1) {
			throw new SmDaoException(e1.getMessage(), e1);
		}
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TransactionDao#findByTitre(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> findByTitre(Long idTitre) throws SmDaoException {
		try {
		Query query=em.createQuery("SELECT t FROM Transaction t WHERE t.titre.id = :idTitre");
		query.setParameter("idTitre", idTitre);
		return query.getResultList();
		} catch (IllegalArgumentException | PersistenceException e1) {
			throw new SmDaoException(e1.getMessage(), e1);
		}
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TransactionDao#findByTransaction(java.lang.Long)
	 */

	@SuppressWarnings("unchecked")
	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TransactionDao#findByAcheteur(java.lang.Long)
	 */
	@Override
	public List<Transaction> findByAcheteur(Long idAcheteur)
			throws SmDaoException {
		try {
			Query query=em.createQuery("SELECT t FROM Transaction t WHERE acheteur.id = :idAcheteur");
			query.setParameter("idAcheteur", idAcheteur);
			return query.getResultList();
			} catch (IllegalArgumentException | PersistenceException e1) {
				throw new SmDaoException(e1.getMessage(), e1);
			}
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TransactionDao#findByVendeur(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> findByVendeur(Long idVendeur)
			throws SmDaoException {
		try {
			Query query=em.createQuery("SELECT t FROM Transaction t WHERE vendeur.id = :idVendeur");
			query.setParameter("idVendeur", idVendeur);
			return query.getResultList();
			} catch (IllegalArgumentException | PersistenceException e1) {
				throw new SmDaoException(e1.getMessage(), e1);
			}
	}
	

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TransactionDao#register(fr.dauphine.secondMarket.sm_webapp.domain.Transaction)
	 */
	@Override
	public void register(Transaction transaction) throws SmDaoException {
		try {
			em.persist(transaction);
			return;
		} catch (IllegalArgumentException | PersistenceException e1) {
			throw new SmDaoException(e1.getMessage(), e1);
		}
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TransactionDao#delete(fr.dauphine.secondMarket.sm_webapp.domain.Transaction)
	 */
	@Override
	public void delete(Transaction transaction) throws SmDaoException {
		try {
			em.remove(transaction);
			return;
		} catch (IllegalArgumentException | TransactionRequiredException e1) {
			throw new SmDaoException(e1.getMessage(), e1);
		}
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TransactionDao#update(fr.dauphine.secondMarket.sm_webapp.domain.Transaction)
	 */
	@Override
	public void update(Transaction transaction) throws SmDaoException {
		try {
			em.merge(transaction);
			return;
		} catch (IllegalArgumentException | TransactionRequiredException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	

}
