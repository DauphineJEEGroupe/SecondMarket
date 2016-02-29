/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.secondMarket.sm_webapp.domain.Societe;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.SocieteDao;

/**
 * @author gnepa.rene.barou
 *
 */
@Repository
@Transactional
public class SocieteDaoImpl implements SocieteDao {

	@Autowired
	private EntityManager em;
	private CriteriaBuilder builder;

	@PostConstruct
	private void init() {
		builder = em.getCriteriaBuilder();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.SocieteDao#findById(java.lang
	 * .Long)
	 */
	@Override
	public Societe findById(int id) throws SmDaoException {
		try {
			return em.find(Societe.class, id);
		} catch (IllegalArgumentException e) {
			throw new SmDaoException(e.getMessage(), e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.SocieteDao#findByName(java.lang
	 * .String)
	 */
	@Override
	public List<Societe> findByName(String name) throws SmDaoException {
		try {
			CriteriaQuery<Societe> criteria = builder
					.createQuery(Societe.class);
			Root<Societe> societe = criteria.from(Societe.class);

			criteria.select(societe).where(
					builder.equal(societe.get("nom"), name));
			return em.createQuery(criteria).getResultList();
		} catch (IllegalArgumentException | PersistenceException e1) {
			throw new SmDaoException(e1.getMessage(), e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.SocieteDao#findAllOrderedByName()
	 */
	@Override
	public List<Societe> findAllOrderedByName() throws SmDaoException {

		try {
			CriteriaQuery<Societe> criteria = builder
					.createQuery(Societe.class);
			Root<Societe> societeRoot = criteria.from(Societe.class);

			criteria.select(societeRoot).orderBy(
					builder.asc(societeRoot.get("nom")));
			return em.createQuery(criteria).getResultList();
		} catch (IllegalArgumentException | PersistenceException e1) {
			throw new SmDaoException(e1.getMessage(), e1);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.SocieteDao#register(fr.dauphine
	 * .secondMarket.sm_webapp.domain.Societe)
	 */
	@Override
	public void register(Societe societe) throws SmDaoException {

		try {
			em.persist(societe);
			return;
		} catch (IllegalArgumentException | PersistenceException e1) {
			throw new SmDaoException(e1.getMessage(), e1);
		}

	}

	@Override
	public Societe findBySiren(String siren) throws SmDaoException {
		Societe result;
		CriteriaQuery<Societe> criteria = builder.createQuery(Societe.class);
		Root<Societe> societe = criteria.from(Societe.class);

		criteria.select(societe).where(
				builder.equal(societe.get("siren"), siren));
		try {
			result = em.createQuery(criteria).getSingleResult();
			return result;
		} catch (NoResultException e) {
			result = null;
			return result;
		} catch (NonUniqueResultException | IllegalArgumentException e1) {
			result = null;
			throw new SmDaoException(e1.getMessage(), e1);
		}

	}

	@Override
	public void delete(Societe societe) throws SmDaoException {

		try {
			em.remove(societe);
			return;
		} catch (IllegalArgumentException | TransactionRequiredException e1) {
			throw new SmDaoException(e1.getMessage(), e1);
		}
	}

	@Override
	public void update(Societe societeToUpdate) throws SmDaoException {

		try {
			em.merge(societeToUpdate);
			return;
		} catch (IllegalArgumentException | TransactionRequiredException e1) {
			throw new SmDaoException(e1.getMessage(), e1);
		}

	}

}
