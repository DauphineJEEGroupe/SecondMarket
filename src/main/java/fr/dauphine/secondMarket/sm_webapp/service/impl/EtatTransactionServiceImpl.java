/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dauphine.secondMarket.sm_webapp.domain.EtatTransaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.EtatTransactionDao;
import fr.dauphine.secondMarket.sm_webapp.service.EtatTransactionService;

/**
 * @author gnepa.rene.barou
 *
 */
@Service
public class EtatTransactionServiceImpl implements EtatTransactionService {

	@Autowired
	private EtatTransactionDao daoEtatTransaction;

	@Override
	public EtatTransaction findById(Long id) throws SmDaoException {
		return daoEtatTransaction.findById(id);
	}

	@Override
	public EtatTransaction findByCode(String code) throws SmDaoException {
		return daoEtatTransaction.findByCode(code);
	}

	@Override
	public List<EtatTransaction> findAllOrderedByCode() throws SmDaoException {
		return daoEtatTransaction.findAllOrderedByCode();
	}

	@Override
	public void register(EtatTransaction etatTransaction) throws SmDaoException {
		daoEtatTransaction.register(etatTransaction);

	}

}
