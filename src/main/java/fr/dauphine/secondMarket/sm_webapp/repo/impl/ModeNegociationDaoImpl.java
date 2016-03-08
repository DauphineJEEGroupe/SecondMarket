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

import fr.dauphine.secondMarket.sm_webapp.domain.ModeNegociation;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.ModeNegociationDao;

/**
 * @author gb2c7dcn
 *
 */

@Repository
@Transactional
public class ModeNegociationDaoImpl implements ModeNegociationDao {
	@Autowired
	private EntityManager em;

	private CriteriaBuilder builder;
	private CriteriaQuery<ModeNegociation> criteria;
	private Root<ModeNegociation> modeNegociationRoot;

	@PostConstruct
	private void init() {
		builder = em.getCriteriaBuilder();
		criteria = builder.createQuery(ModeNegociation.class);
		modeNegociationRoot = criteria.from(ModeNegociation.class);
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.ModeNegociationDao#findById(java.lang.Long)
	 */
	@Override
	public ModeNegociation findById(Long id) throws SmDaoException {
		try {
			return em.find(ModeNegociation.class, id);
		} catch (IllegalArgumentException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.ModeNegociationDao#findByCode(java.lang.String)
	 */
	@Override
	public ModeNegociation findByCode(String code) throws SmDaoException {
		ModeNegociation result;
		try {
			criteria.select(modeNegociationRoot).where(
					builder.equal(modeNegociationRoot.get("code"), code));
			return em.createQuery(criteria).getSingleResult();
		} catch (NoResultException e) {
			result = null;
			return result;
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.ModeNegociationDao#findAllOrderedByCode()
	 */
	@Override
	public List<ModeNegociation> findAllOrderedByCode() throws SmDaoException {
		try {
			criteria.select(modeNegociationRoot).orderBy(
					builder.asc(modeNegociationRoot.get("code")));
			return em.createQuery(criteria).getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.ModeNegociationDao#register(fr.dauphine.secondMarket.sm_webapp.domain.ModeNegociation)
	 */
	@Override
	public void register(ModeNegociation modeNegociation) throws SmDaoException {
		try {
			em.persist(modeNegociation);
			return;
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}

	}

}
