package fr.dauphine.secondMarket.sm_webapp.service;

import fr.dauphine.secondMarket.sm_webapp.domain.User;
import fr.dauphine.secondMarket.sm_webapp.exception.SmTechException;

public interface SecurityService {

	boolean authenticate(User user, String password);

	boolean isActif(User user);

	boolean isAdmin(User user);

	boolean isInvestisseur(User user);

	boolean isMembreSociete(User user);

	String getRole(int role);
	
	User getAuthenticateUser(String email, String password) throws SmTechException;
}
