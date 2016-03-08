/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.Statut;

/**
 * @author gnepa.rene.barou
 *
 */
public interface StatutDao {

	public Statut findById(Long id);

    public Statut findByCode(String code);

    public List<Statut> findAllOrderedByCode();

    public void register(Statut statut);

}
