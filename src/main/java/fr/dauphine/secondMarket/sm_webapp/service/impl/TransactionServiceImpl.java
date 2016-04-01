package fr.dauphine.secondMarket.sm_webapp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dauphine.secondMarket.sm_webapp.domain.Contrat;
import fr.dauphine.secondMarket.sm_webapp.domain.Transaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.TransactionDao;
import fr.dauphine.secondMarket.sm_webapp.service.ContratService;
import fr.dauphine.secondMarket.sm_webapp.service.EtatTransactionService;
import fr.dauphine.secondMarket.sm_webapp.service.TransactionService;
import fr.dauphine.secondMarket.sm_webapp.utils.Constantes;
import fr.dauphine.secondMarket.sm_webapp.utils.UtilsDate;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionDao daoTransaction;

	@Autowired
	ContratService serviceContrat;
	
	@Autowired
	EtatTransactionService serviceEtatTransaction;

	@Override
	public void achat(Transaction transaction)
			throws SmDaoException {
		if(transaction.getAcheteur().getId().equals(transaction.getVendeur().getId())){
			throw new SmDaoException("Erreur: l'acheteur est le vendeur!");
		}
		if(!transaction.getEtatTransaction().getCode().equalsIgnoreCase(Constantes.CODE_TRANSACTION_OUVERTE)){
			throw new SmDaoException("Erreur: La vente est deja close!");
		}
		if(!transaction.getDateCloture().after(new Date())){
			throw new SmDaoException("Erreur: La date de cloture de La vente est deja passée depuis :"+UtilsDate.toString(transaction.getDateCloture()));
		}
		transaction.setPrixTransaction(transaction.getPrixCloture()*transaction.getQuantite());
		if(transaction.getModeNegociation().getCode().equalsIgnoreCase(Constantes.CODE_NEGOCIATION_IMMEDIAT)){
			transaction.setDateCloture(new Date());
			vendu(transaction);
		}else{
			update(transaction);
		}
		
		
	}

	@Override
	public void create(Transaction transaction) throws SmDaoException {

		daoTransaction.register(transaction);

	}

	@Override
	public void delete(Long id) throws SmDaoException {
		Transaction transaction = findById(id);
		if (null != transaction)
			daoTransaction.delete(transaction);

	}

	@Override
	public List<Transaction> findAll() throws SmDaoException {
		return daoTransaction.findAllOrderedByDate();
	}

	@Override
	public List<Transaction> findAllTransactionActif() throws SmDaoException {
		List<Transaction> transactions=daoTransaction.findAllActifOrderedByDate();
		
		return transactions;
	}

	@Override
	public List<Transaction> findByAcheteur(Long idAcheteur)
			throws SmDaoException {
		return daoTransaction.findByAcheteur(idAcheteur);
	}

	@Override
	public Transaction findById(Long id) throws SmDaoException {
		return daoTransaction.findById(id);
	}

	@Override
	public List<Transaction> findBySociete(Long idSociete)
			throws SmDaoException {
		return daoTransaction.findBySociete(idSociete);
	}

	@Override
	public List<Transaction> findByTitre(Long idTitre) throws SmDaoException {
		return  daoTransaction.findByTitre(idTitre);
	}

	@Override
	public Contrat findByTitreForSale(Long idTitre) throws SmDaoException {
		return serviceContrat.findById(idTitre);
	}

	@Override
	public List<Transaction> findByVendeur(Long idVendeur)
			throws SmDaoException {
		return daoTransaction.findByVendeur(idVendeur);
	}

	@Override
	public List<Transaction> search(String fullText) throws SmDaoException {
		
		return daoTransaction.search(fullText);
	}

	@Override
	public void update(Transaction transactionToUpdate) throws SmDaoException {
		Transaction transaction = findById(transactionToUpdate.getId());
		if (null != transaction)
			daoTransaction.update(transactionToUpdate);

	}
	
	private boolean isEnchereClos(Transaction transaction){
		
		if(transaction.getModeNegociation().getCode().equalsIgnoreCase(Constantes.CODE_NEGOCIATION_ENCHERE) && transaction.getDateCloture().before(new Date())){
			return true;
		}
		return false;
	}
	
	private void vendu(Transaction transaction) throws SmDaoException{

		transaction.setEtatTransaction(serviceEtatTransaction.findByCode(Constantes.CODE_TRANSACTION_FERMEE));
		transaction.setActif(false);
		update(transaction);
		serviceContrat.vendu(transaction.getTitre(), transaction.getAcheteur(), transaction.getQuantite());
	
	}
	
	public void checkEnchereToClose(){
		try {
		List<Transaction> transactions=findAllTransactionActif();
		if(null!=transactions && !transactions.isEmpty()){
			for (Transaction transaction : transactions) {
				if(isEnchereClos(transaction)){
						vendu(transaction);
					
				}
			}
		}
		} catch (SmDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
