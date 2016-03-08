/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.TypeContrat;

/**
 * @author gb2c7dcn
 *
 */
public interface TypeContratDao {

	public TypeContrat findById(Long id);

    public TypeContrat findByCode(String code);

    public List<TypeContrat> findAllOrderedByCode();

    public void register(TypeContrat typeContrat);
}
