package fr.dauphine.secondMarket.sm_webapp.service;

import fr.dauphine.secondMarket.sm_webapp.domain.User;
import fr.dauphine.secondMarket.sm_webapp.exception.SmTechException;

public interface SecurityService {

	boolean authenticate(User user, String password);

	boolean isActif(User user);

	boolean isAdmin(int role);

	boolean isInvestisseur(int role);

	boolean isMembreSociete(int role);

	String getRole(int role);
	
	User getAuthenticateUser(String email, String password) throws SmTechException;
}
