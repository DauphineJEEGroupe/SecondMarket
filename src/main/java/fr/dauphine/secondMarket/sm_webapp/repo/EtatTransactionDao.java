package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.EtatTransaction;
/**
 * @author gnepa.rene.barou
 *
 */
public interface EtatTransactionDao {
	
	public EtatTransaction findById(Long id);

    public EtatTransaction findByCode(String code);

    public List<EtatTransaction> findAllOrderedByCode();

    public void register(EtatTransaction etatTransaction);
}
