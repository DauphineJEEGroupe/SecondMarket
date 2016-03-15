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

import fr.dauphine.secondMarket.sm_webapp.domain.User;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.UserDao;

/**
 * @author gnepa.rene.barou
 *
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager em;
	private CriteriaBuilder builder;
	private CriteriaQuery<User> criteria;
	private Root<User> userRoot;

	@PostConstruct
	private void init() {
		builder = em.getCriteriaBuilder();
		criteria = builder.createQuery(User.class);
		userRoot = criteria.from(User.class);
	}

	/**
	 * 
	 */
	public UserDaoImpl() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.UserDao#findById(java.lang.Long)
	 */
	@Override
	public User findById(Long id) throws SmDaoException {
		try {
			return em.find(User.class, id);
		} catch (IllegalArgumentException e) {
			throw new SmDaoException(e.getMessage(), e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.UserDao#findAllOrderedByName()
	 */
	@Override
	public List<User> findAllOrderedByName() throws SmDaoException {
		try {
			criteria.select(userRoot).orderBy(builder.asc(userRoot.get("nom")));
			return em.createQuery(criteria).getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.UserDao#register(fr.dauphine.
	 * secondMarket.sm_webapp.domain.User)
	 */
	@Override
	public void register(User user) throws SmDaoException {
		try {
			em.persist(user);
			return;
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.UserDao#findByEmail(java.lang
	 * .String)
	 */
	@Override
	public User findByEmail(String email) throws SmDaoException {
		User result;
		try {
			criteria.select(userRoot).where(
					builder.equal(userRoot.get("email"), email));
			return em.createQuery(criteria).getSingleResult();
		} catch (NoResultException e) {
			result = null;
			return result;
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	@Override
	public List<User> findByName(String name) throws SmDaoException {
		try {
			this.criteria.where(builder.equal(userRoot.get("nom"), name));
			return em.createQuery(criteria).getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	@Override
	public void delete(User user) throws SmDaoException {
		try {
			em.remove(user);
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	@Override
	public void update(User user) throws SmDaoException {
		try {
			em.merge(user);
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

}
