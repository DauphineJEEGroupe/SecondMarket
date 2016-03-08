/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.ModeNegociation;

/**
 * @author gb2c7dcn
 *
 */
public interface ModeNegociationDao {
	
	public ModeNegociation findById(Long id);

    public ModeNegociation findByCode(String code);

    public List<ModeNegociation> findAllOrderedByCode();

    public void register(ModeNegociation modeNegociation);

}
