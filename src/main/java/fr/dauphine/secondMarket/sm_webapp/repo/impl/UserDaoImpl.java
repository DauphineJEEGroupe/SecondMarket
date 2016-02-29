/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.secondMarket.sm_webapp.domain.User;
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
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.UserDao#findById(java.lang.Long)
	 */
	@Override
	public User findById(int id) {
		return em.find(User.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.UserDao#findAllOrderedByName()
	 */
	@Override
	public List<User> findAllOrderedByName() {
		criteria.select(userRoot).orderBy(builder.asc(userRoot.get("nom")));
		return em.createQuery(criteria).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.UserDao#register(fr.dauphine.
	 * secondMarket.sm_webapp.domain.User)
	 */
	@Override
	public User register(User user) {
		em.persist(user);
		return findByEmail(user.getEmail());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.UserDao#findByEmail(java.lang
	 * .String)
	 */
	@Override
	public User findByEmail(String email) {
		criteria.select(userRoot).where(
				builder.equal(userRoot.get("email"), email));
		return em.createQuery(criteria).getSingleResult();
	}

	@Override
	public List<User> findByName(String name) {
		this.criteria.where(builder.equal(userRoot.get("nom"), name));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public void delete(Integer id) {
		User user = findById(id);

		if (null != user)
			em.remove(user);

	}

	@Override
	public User update(User user) {
		return em.merge(user);
	}

}
