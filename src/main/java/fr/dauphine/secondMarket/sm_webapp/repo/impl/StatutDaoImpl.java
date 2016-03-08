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

import fr.dauphine.secondMarket.sm_webapp.domain.Statut;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.StatutDao;

/**
 * @author gnepa.rene.barou
 *
 */
@Repository
@Transactional
public class StatutDaoImpl implements StatutDao {

	@Autowired
	private EntityManager em;

	private CriteriaBuilder builder;
	private CriteriaQuery<Statut> criteria;
	private Root<Statut> statutRoot;

	@PostConstruct
	private void init() {
		builder = em.getCriteriaBuilder();
		criteria = builder.createQuery(Statut.class);
		statutRoot = criteria.from(Statut.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.StatutDao#findById(java
	 * .lang.Long)
	 */
	@Override
	public Statut findById(Long id) throws SmDaoException {
		try {
			return em.find(Statut.class, id);
		} catch (IllegalArgumentException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.StatutDao#findByEmail(java.lang
	 * .String)
	 */
	@Override
	public Statut findByCode(String code) throws SmDaoException {
		Statut result;
		try {
			criteria.select(statutRoot).where(
					builder.equal(statutRoot.get("code"), code));
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
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.StatutDao#findAllOrderedByCode()
	 */
	@Override
	public List<Statut> findAllOrderedByCode() throws SmDaoException {
		try {
			criteria.select(statutRoot).orderBy(
					builder.asc(statutRoot.get("code")));
			return em.createQuery(criteria).getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.StatutDao#register(fr.dauphine
	 * .secondMarket.sm_webapp.domain.Statut)
	 */
	@Override
	public void register(Statut statut) throws SmDaoException {
		try {
			em.persist(statut);
			return;
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}

	}

}
