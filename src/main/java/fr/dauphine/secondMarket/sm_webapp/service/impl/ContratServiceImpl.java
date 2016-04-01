/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dauphine.secondMarket.sm_webapp.domain.Contrat;
import fr.dauphine.secondMarket.sm_webapp.domain.Investisseur;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmTechException;
import fr.dauphine.secondMarket.sm_webapp.repo.ContratDao;
import fr.dauphine.secondMarket.sm_webapp.service.ContratService;

/**
 * @author gnepa.rene.barou
 *
 */
@Service
public class ContratServiceImpl implements ContratService {

	@Autowired
	private ContratDao daoContrat;

	@Override
	public void create(Contrat newContrat) throws SmDaoException,
			SmTechException {

		if (null == daoContrat.findByUserAndCodeIsin(newContrat.getProprietaire().getId(), newContrat.getCodeIsin())) {
			daoContrat.register(newContrat);
		} else {
			throw new SmTechException("Le titre: "
					+ newContrat.getCodeIsin() + " existe deja");
		}

	}

	@Override
	public void delete(Long id) throws SmDaoException {
		Contrat contrat = findById(id);
		if (null != contrat)
			daoContrat.delete(contrat);

	}

	@Override
	public List<Contrat> findAll() throws SmDaoException {
		return daoContrat.findAllOrderedByCodeIsin();
		}

	@Override
	public List<Contrat> findByInvestisseur(Long idInvestisseur)
			throws SmDaoException {
		return daoContrat.findByUser(idInvestisseur);
	}

	@Override
	public void update(Contrat contratToUpdate) throws SmDaoException {
		Contrat contrat = daoContrat.findByUserAndCodeIsin(contratToUpdate.getProprietaire().getId(), contratToUpdate.getCodeIsin());
		if (null == contrat || contrat.getId() == contratToUpdate.getId()) {
			daoContrat.update(contratToUpdate);
		}

	}

	@Override
	public Contrat findById(Long id) throws SmDaoException {
		return daoContrat.findById(id);
		}

	@Override
	public boolean hasEnoughTitreToSale(Long idTitre, Long nbTitreToSale)
			throws SmException {
		Contrat titre=findById(idTitre);
		if(nbTitreToSale>titre.getNbTitres()){
			throw new SmTechException("Pas assez de titre pour la transaction");
		}
		return true;
	}

	@Override
	public void vendre(Contrat titreAvendre, Long nbTitre) throws SmDaoException {
		long nbTitreRestant=titreAvendre.getNbTitres() - nbTitre;
		titreAvendre.setNbTitres(nbTitreRestant);
		daoContrat.update(titreAvendre);
	}

	@Override
	public void vendu(Contrat titreVendu,Investisseur acheteur, Long nbTitre) throws SmDaoException {
		Contrat newTitre=daoContrat.findByUserAndCodeIsin(acheteur.getId(), titreVendu.getCodeIsin()); 
		if(null==newTitre){
			newTitre=clone(titreVendu);
			newTitre.setProprietaire(acheteur);
			newTitre.setNbTitres(nbTitre);
			daoContrat.register(newTitre);
		}else{
			newTitre.setNbTitres(nbTitre+newTitre.getNbTitres());
			daoContrat.update(newTitre);
		}
		
		
	}
	private Contrat clone(Contrat clonable){
		Contrat titre=new Contrat();
		titre.setCodeIsin(clonable.getCodeIsin());
		titre.setNbTitres(clonable.getNbTitres());
		titre.setProprietaire(clonable.getProprietaire());
		titre.setSociete(clonable.getSociete());
		titre.setTypeContrat(clonable.getTypeContrat());
		titre.setValeur(clonable.getValeur());
		return titre;
	}

}
