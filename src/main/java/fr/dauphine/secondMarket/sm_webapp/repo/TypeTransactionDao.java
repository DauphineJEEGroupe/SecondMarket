/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.TypeTransaction;

/**
 * @author gb2c7dcn
 *
 */
public interface TypeTransactionDao {

	public TypeTransaction findById(Long id);

    public TypeTransaction findByCode(String code);

    public List<TypeTransaction> findAllOrderedByCode();

    public void register(TypeTransaction typeTransaction);
}
