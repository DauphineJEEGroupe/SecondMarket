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

import fr.dauphine.secondMarket.sm_webapp.domain.Societe;
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
	public Societe findById(int id) {
		return em.find(Societe.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.SocieteDao#findByName(java.lang
	 * .String)
	 */
	@Override
	public List<Societe> findByName(String name) {
		CriteriaQuery<Societe> criteria = builder.createQuery(Societe.class);
		Root<Societe> societe = criteria.from(Societe.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe
		 * criteria queries, a new feature in JPA 2.0
		 * criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		 */

		criteria.select(societe).where(builder.equal(societe.get("nom"), name));
		return em.createQuery(criteria).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.SocieteDao#findAllOrderedByName()
	 */
	@Override
	public List<Societe> findAllOrderedByName() {
//		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Societe> criteria = builder.createQuery(Societe.class);
		Root<Societe> societe = criteria.from(Societe.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe
		 * criteria queries, a new feature in JPA 2.0
		 * criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		 */

		criteria.select(societe).orderBy(builder.asc(societe.get("nom")));
		return em.createQuery(criteria).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dauphine.secondMarket.sm_webapp.repo.SocieteDao#register(fr.dauphine
	 * .secondMarket.sm_webapp.domain.Societe)
	 */
	@Override
	public void register(Societe societe) {
		em.persist(societe);
		return;

	}

	@Override
	public Societe findBySiren(String siren) {
		CriteriaQuery<Societe> criteria = builder.createQuery(Societe.class);
		Root<Societe> societe = criteria.from(Societe.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe
		 * criteria queries, a new feature in JPA 2.0
		 * criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		 */

		criteria.select(societe).where(
				builder.equal(societe.get("siren"), siren));
		return em.createQuery(criteria).getSingleResult();
	}

	@Override
	public void delete(Integer id) {
		Societe societe=findById(id);
		if(null!=societe) em.remove(societe);
	}

	@Override
	public void update(Societe societe) {
		em.merge(societe);
	}


}
