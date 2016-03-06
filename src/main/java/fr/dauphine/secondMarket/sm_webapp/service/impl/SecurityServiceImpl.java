package fr.dauphine.secondMarket.sm_webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dauphine.secondMarket.sm_webapp.domain.User;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmTechException;
import fr.dauphine.secondMarket.sm_webapp.service.SecurityService;
import fr.dauphine.secondMarket.sm_webapp.service.UserService;
import fr.dauphine.secondMarket.sm_webapp.utils.Constantes;

@Service
public class SecurityServiceImpl implements SecurityService {
	@Autowired
	private UserService userService;

	public SecurityServiceImpl() {
	}

	@Override
	public boolean authenticate(User user, String password) {

		boolean authentificate = false;
		if (isActif(user) && user.getPass().equals(password)) {
			authentificate = true;
		}
		return authentificate;
	}

	@Override
	public boolean isActif(User user) {
		return user.getActif();
	}

	@Override
	public boolean isAdmin(User user) {
		return Constantes.ROLE_ADMIN.equals(getRole(user.getRole()));
	}

	@Override
	public boolean isInvestisseur(User user) {
		return Constantes.ROLE_INVESTISSEUR.equals(getRole(user.getRole()));
	}

	@Override
	public boolean isMembreSociete(User user) {
		return Constantes.ROLE_MEMBRE_SOCIETE.equals(getRole(user.getRole()));
	}

	@Override
	public String getRole(int role) {
		String result = "";
		switch (role) {
		case 1:
			result = Constantes.ROLE_ADMIN;
			break;
		case 2:
			result = Constantes.ROLE_INVESTISSEUR;
			break;
		case 3:
			result = Constantes.ROLE_MEMBRE_SOCIETE;
			break;
		default:
			result = Constantes.ROLE_AUCUN;
			break;
		}
		return result;
	}

	@Override
	public User getAuthenticateUser(String email, String password)  throws SmTechException{
		User user;
		try {
			user = userService.findByMail(email);
		} catch (SmDaoException e) {
			throw new SmTechException(e.getMessage());
		}
		if(!authenticate(user, password)){
			throw new SmTechException("Erreur de mot de passe");
		}
		
		return user;
	}

}
