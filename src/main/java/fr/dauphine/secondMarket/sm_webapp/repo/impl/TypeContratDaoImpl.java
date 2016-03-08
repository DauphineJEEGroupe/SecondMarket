/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.secondMarket.sm_webapp.domain.TypeContrat;
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

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TypeContratDao#findById(java.lang.Long)
	 */
	@Override
	public TypeContrat findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TypeContratDao#findByCode(java.lang.String)
	 */
	@Override
	public TypeContrat findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TypeContratDao#findAllOrderedByCode()
	 */
	@Override
	public List<TypeContrat> findAllOrderedByCode() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TypeContratDao#register(fr.dauphine.secondMarket.sm_webapp.domain.TypeContrat)
	 */
	@Override
	public void register(TypeContrat typeContrat) {
		// TODO Auto-generated method stub

	}

}
