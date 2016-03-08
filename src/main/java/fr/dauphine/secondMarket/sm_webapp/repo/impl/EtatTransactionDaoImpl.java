/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.secondMarket.sm_webapp.domain.EtatTransaction;
import fr.dauphine.secondMarket.sm_webapp.repo.EtatTransactionDao;

/**
 * @author gb2c7dcn
 *
 */
@Repository
@Transactional
public class EtatTransactionDaoImpl implements EtatTransactionDao {
	
	@Autowired
    private EntityManager em;

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.EtatTransactionDao#findById(java.lang.Long)
	 */
	@Override
	public EtatTransaction findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.EtatTransactionDao#findByCode(java.lang.String)
	 */
	@Override
	public EtatTransaction findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.EtatTransactionDao#findAllOrderedByCode()
	 */
	@Override
	public List<EtatTransaction> findAllOrderedByCode() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.EtatTransactionDao#register(fr.dauphine.secondMarket.sm_webapp.domain.EtatTransaction)
	 */
	@Override
	public void register(EtatTransaction etatTransaction) {
		// TODO Auto-generated method stub

	}

}
