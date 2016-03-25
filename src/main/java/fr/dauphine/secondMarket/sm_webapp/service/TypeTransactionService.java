/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.service;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.TypeTransaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;

/**
 * @author gnepa.rene.barou
 *
 */
public interface TypeTransactionService {
	TypeTransaction findById(Long id) throws SmDaoException;

    TypeTransaction findByCode(String code) throws SmDaoException;

    List<TypeTransaction> findAllOrderedByCode() throws SmDaoException;

    void register(TypeTransaction typeTransaction) throws SmDaoException;
}
