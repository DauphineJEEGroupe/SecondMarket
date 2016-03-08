package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.EtatTransaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
/**
 * @author gnepa.rene.barou
 *
 */
public interface EtatTransactionDao {
	
	public EtatTransaction findById(Long id) throws SmDaoException ;

    public EtatTransaction findByCode(String code) throws SmDaoException ;

    public List<EtatTransaction> findAllOrderedByCode() throws SmDaoException;

    public void register(EtatTransaction etatTransaction) throws SmDaoException;
}
