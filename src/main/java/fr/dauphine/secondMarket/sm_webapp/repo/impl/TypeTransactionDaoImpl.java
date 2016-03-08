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

import fr.dauphine.secondMarket.sm_webapp.domain.TypeTransaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.TypeTransactionDao;

/**
 * @author gb2c7dcn
 *
 */
@Repository
@Transactional
public class TypeTransactionDaoImpl implements TypeTransactionDao {

	@Autowired
	private EntityManager em;

	private CriteriaBuilder builder;
	private CriteriaQuery<TypeTransaction> criteria;
	private Root<TypeTransaction> typeTransactionRoot;

	@PostConstruct
	private void init() {
		builder = em.getCriteriaBuilder();
		criteria = builder.createQuery(TypeTransaction.class);
		typeTransactionRoot = criteria.from(TypeTransaction.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.TypeTransactionDao#findById(java
	 * .lang.Long)
	 */
	@Override
	public TypeTransaction findById(Long id) throws SmDaoException {
		try {
			return em.find(TypeTransaction.class, id);
		} catch (IllegalArgumentException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.TypeTransactionDao#findByCode
	 * (java.lang.String)
	 */
	@Override
	public TypeTransaction findByCode(String code) throws SmDaoException {
		TypeTransaction result;
		try {
			criteria.select(typeTransactionRoot).where(
					builder.equal(typeTransactionRoot.get("code"), code));
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
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TypeTransactionDao#
	 * findAllOrderedByCode()
	 */
	@Override
	public List<TypeTransaction> findAllOrderedByCode() throws SmDaoException {
		try {
			criteria.select(typeTransactionRoot).orderBy(
					builder.asc(typeTransactionRoot.get("code")));
			return em.createQuery(criteria).getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.TypeTransactionDao#register(fr
	 * .dauphine.secondMarket.sm_webapp.domain.TypeTransaction)
	 */
	@Override
	public void register(TypeTransaction typeTransaction) throws SmDaoException {
		try {
			em.persist(typeTransaction);
			return;
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}

	}

}
