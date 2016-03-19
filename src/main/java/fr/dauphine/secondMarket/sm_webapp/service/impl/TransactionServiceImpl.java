package fr.dauphine.secondMarket.sm_webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dauphine.secondMarket.sm_webapp.domain.Contrat;
import fr.dauphine.secondMarket.sm_webapp.domain.Transaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.TransactionDao;
import fr.dauphine.secondMarket.sm_webapp.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionDao daoTransaction;


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
	public List<Transaction> findAllTransactionActif() throws SmDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction findById(Long id) throws SmDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findByTitre(Long idTitre) throws SmDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findBySociete(Long idSociete)
			throws SmDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws SmDaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contrat findByTitreForSale(Long idTitre) throws SmDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Transaction transaction, Long idInvestisseur,
			Long prixInitial, Long prixFinal) throws SmDaoException {
		// TODO Auto-generated method stub
		
	}

}
