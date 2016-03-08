/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.secondMarket.sm_webapp.domain.EtatTransaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.EtatTransactionDao;

/**
 * @author gb2c7dcn
 *
 */
@Repository
@Transactional
public class EtatTransactionDaoImpl implements EtatTransactionDao {

	@Autowired
	private EntityManager em;

	private CriteriaBuilder builder;
	private CriteriaQuery<EtatTransaction> criteria;
	private Root<EtatTransaction> etatTransactionRoot;

	@PostConstruct
	private void init() {
		builder = em.getCriteriaBuilder();
		criteria = builder.createQuery(EtatTransaction.class);
		etatTransactionRoot = criteria.from(EtatTransaction.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.EtatTransactionDao#findById(java
	 * .lang.Long)
	 */
	@Override
	public EtatTransaction findById(Long id) throws SmDaoException {
		try {
			return em.find(EtatTransaction.class, id);
		} catch (IllegalArgumentException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.EtatTransactionDao#findByCode
	 * (java.lang.String)
	 */
	@Override
	public EtatTransaction findByCode(String code) throws SmDaoException {
		EtatTransaction result;
		try {
			criteria.select(etatTransactionRoot).where(
					builder.equal(etatTransactionRoot.get("code"), code));
			return em.createQuery(criteria).getSingleResult();
		} catch (NoResultException e) {
			result = null;
			return result;
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.EtatTransactionDao#
	 * findAllOrderedByCode()
	 */
	@Override
	public List<EtatTransaction> findAllOrderedByCode() throws SmDaoException {
		try {
			criteria.select(etatTransactionRoot).orderBy(
					builder.asc(etatTransactionRoot.get("code")));
			return em.createQuery(criteria).getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.EtatTransactionDao#register(fr
	 * .dauphine.secondMarket.sm_webapp.domain.EtatTransaction)
	 */
	@Override
	public void register(EtatTransaction etatTransaction) throws SmDaoException {
		try {
			em.persist(etatTransaction);
			return;
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

}
