/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dauphine.secondMarket.sm_webapp.domain.TypeTransaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.TypeTransactionDao;
import fr.dauphine.secondMarket.sm_webapp.service.TypeTransactionService;

/**
 * @author gnepa.rene.barou
 *
 */
@Service
public class TypeTransactionServiceImpl implements TypeTransactionService {

	@Autowired
	private TypeTransactionDao daoTypeTransaction;

	@Override
	public TypeTransaction findById(Long id) throws SmDaoException {
		return daoTypeTransaction.findById(id);
	}
	@Override
	public TypeTransaction findByCode(String code) throws SmDaoException {
		return daoTypeTransaction.findByCode(code);
	}
	@Override
	public List<TypeTransaction> findAllOrderedByCode() throws SmDaoException {
		return daoTypeTransaction.findAllOrderedByCode();
	}
	@Override
	public void register(TypeTransaction typeTransaction) throws SmDaoException {
		daoTypeTransaction.register(typeTransaction);
		
	}

}
