/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.TypeTransaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;

/**
 * @author gb2c7dcn
 *
 */
public interface TypeTransactionDao {

	public TypeTransaction findById(Long id) throws SmDaoException;

    public TypeTransaction findByCode(String code) throws SmDaoException;

    public List<TypeTransaction> findAllOrderedByCode() throws SmDaoException;

    public void register(TypeTransaction typeTransaction) throws SmDaoException;
}
