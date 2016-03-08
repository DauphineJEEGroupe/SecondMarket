/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.Statut;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;

/**
 * @author gnepa.rene.barou
 *
 */
public interface StatutDao {

	public Statut findById(Long id) throws SmDaoException;

    public Statut findByCode(String code) throws SmDaoException;

    public List<Statut> findAllOrderedByCode() throws SmDaoException;

    public void register(Statut statut) throws SmDaoException;

}
