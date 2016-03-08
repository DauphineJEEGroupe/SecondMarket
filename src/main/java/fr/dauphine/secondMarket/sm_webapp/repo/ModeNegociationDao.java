/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.ModeNegociation;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;

/**
 * @author gb2c7dcn
 *
 */
public interface ModeNegociationDao {
	
	public ModeNegociation findById(Long id) throws SmDaoException;

    public ModeNegociation findByCode(String code) throws SmDaoException;

    public List<ModeNegociation> findAllOrderedByCode() throws SmDaoException;

    public void register(ModeNegociation modeNegociation) throws SmDaoException;

}
