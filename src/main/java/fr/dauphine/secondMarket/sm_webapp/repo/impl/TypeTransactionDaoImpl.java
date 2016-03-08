/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dauphine.secondMarket.sm_webapp.domain.TypeTransaction;
import fr.dauphine.secondMarket.sm_webapp.repo.TypeTransactionDao;

/**
 * @author gb2c7dcn
 *
 */
@Repository
@Transactional
public class TypeTransactionDaoImpl implements TypeTransactionDao {
	
	@Autowired
	private EntityManager em;

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TypeTransactionDao#findById(java.lang.Long)
	 */
	@Override
	public TypeTransaction findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TypeTransactionDao#findByCode(java.lang.String)
	 */
	@Override
	public TypeTransaction findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TypeTransactionDao#findAllOrderedByCode()
	 */
	@Override
	public List<TypeTransaction> findAllOrderedByCode() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.dauphine.secondMarket.sm_webapp.repo.TypeTransactionDao#register(fr.dauphine.secondMarket.sm_webapp.domain.TypeTransaction)
	 */
	@Override
	public void register(TypeTransaction typeTransaction) {
		// TODO Auto-generated method stub

	}

}
