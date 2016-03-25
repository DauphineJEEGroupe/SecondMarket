/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dauphine.secondMarket.sm_webapp.domain.ModeNegociation;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.ModeNegociationDao;
import fr.dauphine.secondMarket.sm_webapp.service.ModeNegociationService;

/**
 * @author gnepa.rene.barou
 *
 */
@Service
public class ModeNegociationServiceImpl implements ModeNegociationService {

	@Autowired
	private ModeNegociationDao daoModeNegociation;

	@Override
	public ModeNegociation findById(Long id) throws SmDaoException {
		return daoModeNegociation.findById(id);
	}
	@Override
	public ModeNegociation findByCode(String code) throws SmDaoException {
		return daoModeNegociation.findByCode(code);
	}
	@Override
	public List<ModeNegociation> findAllOrderedByCode() throws SmDaoException {
		return daoModeNegociation.findAllOrderedByCode();
	}
	@Override
	public void register(ModeNegociation modeNegociation) throws SmDaoException {
		daoModeNegociation.register(modeNegociation);
		
	}

}