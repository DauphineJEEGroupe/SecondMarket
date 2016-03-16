/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.dauphine.secondMarket.sm_webapp.domain.Contrat;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmTechException;
import fr.dauphine.secondMarket.sm_webapp.service.ContratService;

/**
 * @author gnepa.rene.barou
 *
 */
@Service
public class ContratServiceImpl implements ContratService {

	/**
	 * 
	 */
	public ContratServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Contrat newContrat, String mailInvestisseur,
			String typeContrat, String siren) throws SmDaoException,
			SmTechException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) throws SmDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Contrat> findAll() throws SmDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contrat> findByInvestisseur(Long idInvestisseur)
			throws SmDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Contrat contratToUpdate) throws SmDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Contrat findById(int id) throws SmDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
