/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.TypeContrat;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;

/**
 * @author gb2c7dcn
 *
 */
public interface TypeContratDao {

	 TypeContrat findById(Long id) throws SmDaoException;

     TypeContrat findByCode(String code) throws SmDaoException;

     List<TypeContrat> findAllOrderedByCode() throws SmDaoException;

     void register(TypeContrat typeContrat) throws SmDaoException;
}
