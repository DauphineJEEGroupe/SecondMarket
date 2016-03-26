package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.dauphine.secondMarket.sm_webapp.domain.Investisseur;
import fr.dauphine.secondMarket.sm_webapp.domain.User;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmException;
import fr.dauphine.secondMarket.sm_webapp.service.UserService;
import fr.dauphine.secondMarket.sm_webapp.utils.Constantes;

@Controller
public class UserController {

	Logger logger = Logger.getLogger(UserController.class.getCanonicalName());

	@Autowired
	private UserService userService;

	public UserController() {
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String displayUser(Model model) {
		logger.info("displayUser()");
		List<User> users = new ArrayList<User>();
		try {
			users = userService.findAll();
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
		}
		model.addAttribute("users", users);
		model.addAttribute("newUser", new User());
		return "membre/back/user/list";

	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String registerNewUser(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		logger.info("registerNewUser()");
		if (result.hasErrors()) {
			StringBuilder erreur = new StringBuilder();
			for (ObjectError error : result.getAllErrors()) {
				erreur.append(error.getObjectName() + "---"
						+ error.getDefaultMessage() + " \n ---");
			}
			redirectAttributes.addFlashAttribute("erreur", erreur.toString());
		} else {
			newUser.setActif(true);
			newUser.setPass(newUser.getNom());
			newUser.setRole(1);
			try {
				userService.create(newUser);
				redirectAttributes.addFlashAttribute("message",
						"Enregistrement avec succes de " + newUser.getNom());
			} catch (SmException e) {
				logger.severe(e.getMessage());
				redirectAttributes.addFlashAttribute("erreur", e.getMessage());
			}
		}

		return "redirect:/user";

	}

	@RequestMapping(value = "/public/inscription", method = RequestMethod.GET)
	public String newInvestisseurForm(Model model) {
		logger.info("newInvestisseurForm(): GET");
		model.addAttribute("newInvestisseur", new Investisseur());
		return "public/inscription";
	}

	@RequestMapping(value = "/public/inscription", method = RequestMethod.POST)
	public String registerNewInvestisseur(
			@Valid @ModelAttribute("newInvestisseur") Investisseur newInvestisseur,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		logger.info("registerNewInvestisseur()");
		if (result.hasErrors()) {
			model.addAttribute("newInvestisseur", newInvestisseur);
			logger.severe("result.hasErrors()");
			return "/public/inscription";
		}
		
		if (!newInvestisseur.getPass().equalsIgnoreCase(
				newInvestisseur.getPass2())) {
			model.addAttribute("newInvestisseur", newInvestisseur);
			return "/public/inscription";
		}
		

		try {
			validationEmail(newInvestisseur.getEmail());
			validationMotsDePasse(newInvestisseur.getPass(), newInvestisseur.getPass2());
			validationNom(newInvestisseur.getNom());
			Investisseur newUser = new Investisseur();
			newUser.setNom(newInvestisseur.getNom());
			newUser.setPhoneNumber(newInvestisseur.getPhoneNumber());
			newUser.setPrenom(newInvestisseur.getNom());
			newUser.setEmail(newInvestisseur.getEmail());
			newUser.setActif(true);
			newUser.setPass(newInvestisseur.getPass());
			newUser.setRole(Constantes.ROLE_INVESTISSEUR_CODE);
			newUser.setProfilInvestisseur("");
			
			userService.create(newUser);
		} catch (SmException e) {
			logger.severe(e.getMessage());
			redirectAttributes.addFlashAttribute("erreur", e.getMessage());
		}

		return "redirect:/public/login";

	}
	

	private void validationEmail( String email ) throws SmException {
	    if ( email != null ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new SmException( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new SmException( "Merci de saisir une adresse mail." );
	    }
	}

	private void validationMotsDePasse( String motDePasse, String confirmation ) throws SmException {
	    if ( motDePasse != null && confirmation != null ) {
	        if ( !motDePasse.equals( confirmation ) ) {
	            throw new SmException( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
	        } else if ( motDePasse.length() < 3 ) {
	            throw new SmException( "Les mots de passe doivent contenir au moins 3 caractères." );
	        }
	    } else {
	        throw new SmException( "Merci de saisir et confirmer votre mot de passe." );
	    }
	}

	private void validationNom( String nom ) throws SmException {
	    if ( nom != null && nom.length() < 3 ) {
	        throw new SmException( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
	    }
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
//	private void setErreur( String champ, String message ) {
//	    erreurs.put( champ, message );
//	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	// private static String getValeurChamp( HttpServletRequest request, String
	// nomChamp ) {
	// String valeur = request.getParameter( nomChamp );
	// if ( valeur == null || valeur.trim().length() == 0 ) {
	// return null;
	// } else {
	// return valeur.trim();
	// }
	// }

}
