/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dauphine.secondMarket.sm_webapp.domain.TypeContrat;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.repo.TypeContratDao;
import fr.dauphine.secondMarket.sm_webapp.service.TypeContratService;

/**
 * @author gnepa.rene.barou
 *
 */
@Service
public class TypeContratServiceImpl implements TypeContratService {
	@Autowired
	private TypeContratDao daoTypeContrat;

	@Override
	public TypeContrat findById(Long id) throws SmDaoException {
		return daoTypeContrat.findById(id);
	}
	@Override
	public TypeContrat findByCode(String code) throws SmDaoException {
		return daoTypeContrat.findByCode(code);
	}
	@Override
	public List<TypeContrat> findAllOrderedByCode() throws SmDaoException {
		return daoTypeContrat.findAllOrderedByCode();
	}
	@Override
	public void register(TypeContrat typeContrat) throws SmDaoException {
		daoTypeContrat.register(typeContrat);
		
	}

}
