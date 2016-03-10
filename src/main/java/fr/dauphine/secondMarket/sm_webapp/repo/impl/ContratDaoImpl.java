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

import fr.dauphine.secondMarket.sm_webapp.domain.Contrat;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.ContratDao;

public class ContratDaoImpl implements ContratDao {
	@Autowired
	private EntityManager em;
	private CriteriaBuilder builder;

	@PostConstruct
	private void init() {
		builder = em.getCriteriaBuilder();
	}

	@Override
	public Contrat findById(int id) throws SmDaoException {
		try {
			return em.find(Contrat.class, id);
		} catch (IllegalArgumentException e) {
			throw new SmDaoException(e.getMessage(), e);
		}
	}

	@Override
	public Contrat findByCodeIsin(String codeIsin) throws SmDaoException {
		Contrat result;
		CriteriaQuery<Contrat> criteria = builder.createQuery(Contrat.class);
		Root<Contrat> contrat = criteria.from(Contrat.class);

		criteria.select(contrat).where(
				builder.equal(contrat.get("codeIsin"), codeIsin));
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
	public List<Contrat> findByValeur(Long valeur) throws SmDaoException {
		try {
			CriteriaQuery<Contrat> criteria = builder
					.createQuery(Contrat.class);
			Root<Contrat> contrat = criteria.from(Contrat.class);

			criteria.select(contrat).where(
					builder.equal(contrat.get("valeur"), valeur));
			return em.createQuery(criteria).getResultList();
		} catch (IllegalArgumentException | PersistenceException e1) {
			throw new SmDaoException(e1.getMessage(), e1);
		}
	}

	@Override
	public List<Contrat> findAllOrderedByCodeIsin() throws SmDaoException {
		try {
			CriteriaQuery<Contrat> criteria = builder
					.createQuery(Contrat.class);
			Root<Contrat> contratRoot = criteria.from(Contrat.class);

			criteria.select(contratRoot).orderBy(
					builder.asc(contratRoot.get("codeIsin")));
			return em.createQuery(criteria).getResultList();
		} catch (IllegalArgumentException | PersistenceException e1) {
			throw new SmDaoException(e1.getMessage(), e1);
		}
	}

	@Override
	public void register(Contrat contrat) throws SmDaoException {
		try {
			em.persist(contrat);
			return;
		} catch (IllegalArgumentException | PersistenceException e1) {
			throw new SmDaoException(e1.getMessage(), e1);
		}

	}

	@Override
	public void delete(Contrat contrat) throws SmDaoException {
		try {
			em.remove(contrat);
			return;
		} catch (IllegalArgumentException | TransactionRequiredException e1) {
			throw new SmDaoException(e1.getMessage(), e1);
		}
	}

	@Override
	public void update(Contrat contrat) throws SmDaoException {
		try {
			em.merge(contrat);
			return;
		} catch (IllegalArgumentException | TransactionRequiredException e1) {
			throw new SmDaoException(e1.getMessage(), e1);
		}
	}

	@Override
	public List<Contrat> findByUser(Long idUser) throws SmDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
