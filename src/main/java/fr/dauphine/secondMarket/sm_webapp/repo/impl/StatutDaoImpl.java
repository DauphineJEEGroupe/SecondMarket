/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.secondMarket.sm_webapp.domain.Statut;
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

	/**
	 * 
	 */
	public StatutDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.StatutDao#findById(java.lang.Long)
	 */
	@Override
	public Statut findById(Long id) {
		 return em.find(Statut.class, id);
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.StatutDao#findByEmail(java.lang.String)
	 */
	@Override
	public Statut findByName(String name) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Statut> criteria = builder.createQuery(Statut.class);
        Root<Statut> statut = criteria.from(Statut.class);

        criteria.select(statut).where(builder.equal(statut.get("nom"), name));
        return em.createQuery(criteria).getSingleResult();
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.StatutDao#findAllOrderedByName()
	 */
	@Override
	public List<Statut> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Statut> criteria = cb.createQuery(Statut.class);
        Root<Statut> statut = criteria.from(Statut.class);

        criteria.select(statut).orderBy(cb.asc(statut.get("nom")));
        return em.createQuery(criteria).getResultList();
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.StatutDao#register(fr.dauphine.secondMarket.sm_webapp.domain.Statut)
	 */
	@Override
	public void register(Statut statut) {
		em.persist(statut);
        return;

	}

}
