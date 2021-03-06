package fr.dauphine.secondMarket.sm_webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dauphine.secondMarket.sm_webapp.domain.MembreSociete;
import fr.dauphine.secondMarket.sm_webapp.domain.Societe;
import fr.dauphine.secondMarket.sm_webapp.domain.Statut;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmTechException;
import fr.dauphine.secondMarket.sm_webapp.repo.SocieteDao;
import fr.dauphine.secondMarket.sm_webapp.repo.StatutDao;
import fr.dauphine.secondMarket.sm_webapp.service.SocieteService;
import fr.dauphine.secondMarket.sm_webapp.service.UserService;
import fr.dauphine.secondMarket.sm_webapp.utils.Constantes;

@Service
public class SocieteServiceImpl implements SocieteService {
	@Autowired
	private SocieteDao societeDao;
	@Autowired
	private StatutDao statutDao;
	
	@Autowired
	private UserService userService;

	public SocieteServiceImpl() {
	}

	@Override
	public void create(Societe newSociete) throws SmDaoException,
			SmTechException {

		if (null == societeDao.findBySiren(newSociete.getSiren())) {
			Statut statut = statutDao.findByCode(Constantes.STATUT_REFERENCEE);
			newSociete.setStatut(statut);
			societeDao.register(newSociete);
		} else {
			throw new SmTechException("La société avec le siren: "
					+ newSociete.getSiren() + " existe deja");
		}

	}

	@Override
	public void delete(Long id) throws SmDaoException {
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
		Societe societe = societeDao.findBySiren(societeToUpdate.getSiren());
		if (null == societe || societe.getId() == societeToUpdate.getId()) {
			societeDao.update(societeToUpdate);
		}

	}

	@Override
	public Societe findById(Long id) throws SmDaoException {
		return societeDao.findById(id);
	}

	@Override
	public void accredit(Societe societe) throws SmDaoException {
		MembreSociete newUser =societe.getRepresentant();
		try {
			userService.create(newUser);
		} catch (SmTechException e) {
			throw new SmDaoException(e.getMessage(), e.getCause());
		}
			Statut statut = statutDao.findByCode(Constantes.STATUT_ACCREDITEE);
			societe.setStatut(statut);
			societe.setRepresentant(newUser);
			societeDao.update(societe);
	}

	@Override
	public List<Societe> search(String fullText) throws SmDaoException {
		return societeDao.search(fullText);
	}

}
