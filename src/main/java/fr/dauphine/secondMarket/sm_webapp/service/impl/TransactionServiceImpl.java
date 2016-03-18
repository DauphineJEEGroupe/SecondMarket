package fr.dauphine.secondMarket.sm_webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dauphine.secondMarket.sm_webapp.domain.Transaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.TransactionDao;
import fr.dauphine.secondMarket.sm_webapp.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionDao daoTransaction;

	@Override
	public void create(Long idContrat, Long idInvestisseur, Long prixInitial,
			Long prixFinal, String etat) throws SmDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Transaction> findTransactionActif() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) throws SmDaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Transaction> findAll() throws SmDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findByInvestisseur(Long idInvestisseur)
			throws SmDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Transaction transactionToUpdate) throws SmDaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Transaction findById(int id) throws SmDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
