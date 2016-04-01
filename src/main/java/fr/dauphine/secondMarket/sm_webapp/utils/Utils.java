/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import fr.dauphine.secondMarket.sm_webapp.exception.SmException;

/**
 * @author gnepa.rene.barou
 *
 */
public class Utils {

	public static String errorsStringBuilder(BindingResult result) {
		StringBuilder erreur = new StringBuilder();
		erreur.append("<p style=\" color: #a94442;\"> <strong>Erreurs!</strong></p>");
		for (FieldError error : result.getFieldErrors()) {
			erreur.append("<div class=\"alert alert-warning\">");
			erreur.append(" ---" + error.getField() + "= \""
					+ error.getRejectedValue() + "\" :"
					+ error.getDefaultMessage() + " \n");
			erreur.append(" </div>");
		}
		return erreur.toString();
	}

	public static String errorStringBuilder(String error) {
		StringBuilder erreur = new StringBuilder();
		erreur.append("<div class=\"alert alert-warning\">");
		erreur.append(error);
		erreur.append(" </div>");
		return erreur.toString();
	}

	public static String msgStringBuilder(String result) {
		StringBuilder erreur = new StringBuilder();
		erreur.append("<div class=\"alert alert-success\">");
		erreur.append(result);
		erreur.append(" </div>");
		return erreur.toString();

	}

	public static void validationEmail(String email) throws SmException {
		if (email != null) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new SmException(
						"Merci de saisir une adresse mail valide.");
			}
		} else {
			throw new SmException("Merci de saisir une adresse mail.");
		}
	}

	public static void validationMotsDePasse(String motDePasse,
			String confirmation) throws SmException {
		if (motDePasse != null && confirmation != null) {
			if (!motDePasse.equals(confirmation)) {
				throw new SmException(
						"Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			} else if (motDePasse.length() < 3) {
				throw new SmException(
						"Les mots de passe doivent contenir au moins 3 caractères.");
			}
		} else {
			throw new SmException(
					"Merci de saisir et confirmer votre mot de passe.");
		}
	}

	public static void validationNom(String nom) throws SmException {
		if (nom != null && nom.length() < 3) {
			throw new SmException(
					"Le nom d'utilisateur doit contenir au moins 3 caractères.");
		}
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	// public static void setErreur( String champ, String message ) {
	// erreurs.put( champ, message );
	// }

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	// public static String getValeurChamp( HttpServletRequest request, String
	// nomChamp ) {
	// String valeur = request.getParameter( nomChamp );
	// if ( valeur == null || valeur.trim().length() == 0 ) {
	// return null;
	// } else {
	// return valeur.trim();
	// }
	// }
}
