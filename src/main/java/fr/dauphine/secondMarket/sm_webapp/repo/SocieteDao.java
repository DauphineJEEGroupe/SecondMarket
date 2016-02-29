/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.Societe;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;

/**
 * @author gnepa.rene.barou
 *
 */
public interface SocieteDao {

	Societe findById(int id) throws SmDaoException;

	Societe findBySiren(String siren) throws SmDaoException;

	List<Societe> findByName(String name) throws SmDaoException;

	List<Societe> findAllOrderedByName() throws SmDaoException;

	void register(Societe societe) throws SmDaoException;

	void delete(Societe societe) throws SmDaoException;

	void update(Societe societe) throws SmDaoException;

}
