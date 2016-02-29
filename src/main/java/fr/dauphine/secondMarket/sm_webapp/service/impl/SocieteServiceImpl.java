package fr.dauphine.secondMarket.sm_webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dauphine.secondMarket.sm_webapp.domain.Societe;
import fr.dauphine.secondMarket.sm_webapp.domain.Statut;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmTechException;
import fr.dauphine.secondMarket.sm_webapp.repo.SocieteDao;
import fr.dauphine.secondMarket.sm_webapp.repo.StatutDao;
import fr.dauphine.secondMarket.sm_webapp.service.SocieteService;
import fr.dauphine.secondMarket.sm_webapp.utils.Constantes;

@Service
public class SocieteServiceImpl implements SocieteService {
	@Autowired
	private SocieteDao societeDao;
	@Autowired
	private StatutDao statutDao;

	public SocieteServiceImpl() {
	}

	@Override
	public void create(Societe newSociete) throws SmDaoException, SmTechException {

		if (null == societeDao.findBySiren(newSociete.getSiren())) {
			Statut statut = statutDao.findByName(Constantes.STATUT_REFERENCEE);
			newSociete.setStatut(statut);
			societeDao.register(newSociete);
		}else{
			throw new SmTechException("La société avec le siren: "+newSociete.getSiren()+" existe deja");
		}

	}

	@Override
	public void delete(int id) throws SmDaoException {
		Societe societe = findById(id);
		if (null != societe)
			societeDao.delete(societe);

	}

	@Override
	public List<Societe> findAll() throws SmDaoException {
		return societeDao.findAllOrderedByName();
	}

	@Override
	public void update(Societe societeToUpdate) throws SmDaoException {
		Societe societe;
			societe = societeDao.findBySiren(societeToUpdate.getSiren());
			if (null == societe || societe.getId() == societeToUpdate.getId()) {
				societeDao.update(societeToUpdate);
			}

	}

	@Override
	public Societe findById(int id) throws SmDaoException {
		return societeDao.findById(id);
	}

	@Override
	public void accredit(int id) throws SmDaoException {
		Societe societeToUpdate = societeDao.findById(id);
		if (null != societeToUpdate) {
			Statut statut = statutDao.findByName(Constantes.STATUT_ACCREDITEE);
			societeToUpdate.setStatut(statut);
			societeDao.update(societeToUpdate);
		}

	}

}
