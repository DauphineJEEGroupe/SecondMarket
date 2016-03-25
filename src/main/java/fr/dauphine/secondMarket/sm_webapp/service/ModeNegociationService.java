/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.ModeNegociation;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;

/**
 * @author gnepa.rene.barou
 *
 */
public interface ModeNegociationService {
	ModeNegociation findById(Long id) throws SmDaoException;

    ModeNegociation findByCode(String code) throws SmDaoException;

    List<ModeNegociation> findAllOrderedByCode() throws SmDaoException;

    void register(ModeNegociation modeNegociation) throws SmDaoException;
}
