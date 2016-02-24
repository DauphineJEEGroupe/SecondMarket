/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.Societe;


/**
 * @author gnepa.rene.barou
 *
 */
public interface SocieteDao {
	public Societe findById(int id);
	
	public Societe findBySiren(String siren);
	
    public List<Societe> findByName(String name);

    public List<Societe> findAllOrderedByName();

    public void register(Societe societe);
    
    public void delete(Integer id);
    
    public void update(Societe societe);
    
}
