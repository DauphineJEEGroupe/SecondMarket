package fr.dauphine.secondMarket.sm_webapp.repo;

import java.util.List;

import fr.dauphine.secondMarket.sm_webapp.domain.Contrat;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;

public interface ContratDao {

	Contrat findById(Long id) throws SmDaoException;

	Contrat findByCodeIsin(String codeIsin) throws SmDaoException;
	
	Contrat findByUserAndCodeIsin(Long idUser, String codeIsin) throws SmDaoException;

	List<Contrat> findByValeur(Long valeur) throws SmDaoException;
	
	List<Contrat> findByUser(Long idUser) throws SmDaoException;
	
	List<Contrat> findAllOrderedByCodeIsin() throws SmDaoException;

	void register(Contrat contrat) throws SmDaoException;

	void delete(Contrat contrat) throws SmDaoException;

	void update(Contrat contrat) throws SmDaoException;
}
