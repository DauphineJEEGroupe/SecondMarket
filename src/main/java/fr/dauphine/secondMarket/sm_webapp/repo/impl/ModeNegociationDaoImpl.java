/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.secondMarket.sm_webapp.domain.ModeNegociation;
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

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.ModeNegociationDao#findById(java.lang.Long)
	 */
	@Override
	public ModeNegociation findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.ModeNegociationDao#findByCode(java.lang.String)
	 */
	@Override
	public ModeNegociation findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.ModeNegociationDao#findAllOrderedByCode()
	 */
	@Override
	public List<ModeNegociation> findAllOrderedByCode() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.ModeNegociationDao#register(fr.dauphine.secondMarket.sm_webapp.domain.ModeNegociation)
	 */
	@Override
	public void register(ModeNegociation modeNegociation) {
		// TODO Auto-generated method stub

	}

}
