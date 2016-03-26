/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dauphine.secondMarket.sm_webapp.domain.Contrat;
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
	public boolean hasEnoughTitreToSale(Long idTitre, Integer nbTitreToSale)
			throws SmException {
		Contrat titre=findById(idTitre);
		if(nbTitreToSale>titre.getNbTitres()){
			throw new SmTechException("Pas assez de titre pour la transaction");
		}
		return true;
	}
	

}
