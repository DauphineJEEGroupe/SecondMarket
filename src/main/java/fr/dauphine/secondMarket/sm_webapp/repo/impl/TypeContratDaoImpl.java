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

import fr.dauphine.secondMarket.sm_webapp.domain.TypeContrat;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.TypeContratDao;

/**
 * @author gb2c7dcn
 *
 */
@Repository
@Transactional
public class TypeContratDaoImpl implements TypeContratDao {
	
	@Autowired
    private EntityManager em;
	
	private CriteriaBuilder builder;
	private CriteriaQuery<TypeContrat> criteria;
	private Root<TypeContrat> typeContratRoot;

	@PostConstruct
	private void init() {
		builder = em.getCriteriaBuilder();
		criteria = builder.createQuery(TypeContrat.class);
		typeContratRoot = criteria.from(TypeContrat.class);
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TypeContratDao#findById(java.lang.Long)
	 */
	@Override
	public TypeContrat findById(Long id) throws SmDaoException {
		try {
			return em.find(TypeContrat.class, id);
		} catch (IllegalArgumentException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TypeContratDao#findByCode(java.lang.String)
	 */
	@Override
	public TypeContrat findByCode(String code) throws SmDaoException {
		TypeContrat result;
		try {
			criteria.select(typeContratRoot).where(
					builder.equal(typeContratRoot.get("code"), code));
			return em.createQuery(criteria).getSingleResult();
		} catch (NoResultException e) {
			result = null;
			return result;
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TypeContratDao#findAllOrderedByCode()
	 */
	@Override
	public List<TypeContrat> findAllOrderedByCode() throws SmDaoException {
		try {
			criteria.select(typeContratRoot).orderBy(
					builder.asc(typeContratRoot.get("code")));
			return em.createQuery(criteria).getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TypeContratDao#register(fr.dauphine.secondMarket.sm_webapp.domain.TypeContrat)
	 */
	@Override
	public void register(TypeContrat typeContrat)  throws SmDaoException {
		try {
			em.persist(typeContrat);
			return;
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

}
