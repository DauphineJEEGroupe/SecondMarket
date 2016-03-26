/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.dauphine.secondMarket.sm_webapp.domain.Contrat;
import fr.dauphine.secondMarket.sm_webapp.domain.Investisseur;
import fr.dauphine.secondMarket.sm_webapp.domain.Societe;
import fr.dauphine.secondMarket.sm_webapp.domain.TypeContrat;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmException;
import fr.dauphine.secondMarket.sm_webapp.mvc.bean.UserBean;
import fr.dauphine.secondMarket.sm_webapp.service.ContratService;
import fr.dauphine.secondMarket.sm_webapp.service.SocieteService;
import fr.dauphine.secondMarket.sm_webapp.service.TransactionService;
import fr.dauphine.secondMarket.sm_webapp.service.TypeContratService;
import fr.dauphine.secondMarket.sm_webapp.service.UserService;
import fr.dauphine.secondMarket.sm_webapp.utils.UtilsSession;

/**
 * @author gnepa.rene.barou
 * 
 */
@Controller
@RequestMapping(value = "/investisseur")
public class InvestisseursController {

	private static Logger logger = Logger
			.getLogger(InvestisseursController.class.getCanonicalName());
	@Autowired
	UserService serviceUser;
	@Autowired
	SocieteService serviceSociete;
	@Autowired
	ContratService serviceContrat;
	@Autowired
	TypeContratService serviceTypeContrat;
	@Autowired
	TransactionService serviceTransaction;

	@RequestMapping(method = RequestMethod.GET)
	public String main(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		logger.info("main()");

		try {
			UserBean userBean = UtilsSession.getUserBean(request);
			model.addAttribute("titres", serviceContrat
					.findByInvestisseur(userBean.getId()));
			
			model.addAttribute("investisseur", (Investisseur) serviceUser
					.findById(userBean.getId()));
			model.addAttribute("transactions",serviceTransaction.findByVendeur(userBean.getId()));
			model.addAttribute("userBean", userBean);
			return "membre/front/investisseur/profilInvestisseur";
		} catch (SmDaoException e) {
			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
			return "redirect:/public/login";
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
			return "redirect:/public/login";
		}

	}

	@RequestMapping(value = "/Vente", method = RequestMethod.GET)
	public String vente(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			UserBean userBean = UtilsSession.getUserBean(request);
			List<Contrat> titres = serviceContrat.findByInvestisseur(userBean
					.getId());
			model.addAttribute("titres", titres);
			return "membre/front/investisseur/listeTitres";
		} catch (SmException e) {
			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
			return "/investisseur";
		}

	}

	@RequestMapping(value = "/Titre/ajout", method = RequestMethod.GET)
	public String ajoutTitre(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			UserBean userBean = UtilsSession.getUserBean(request);
			Investisseur investisseur = (Investisseur) serviceUser
					.findById(userBean.getId());
			Contrat newTitre = new Contrat();
			newTitre.setProprietaire(investisseur);
			newTitre.setValeur(0L);
			newTitre.setNbTitres(0);
			newTitre.setSociete(new Societe());
			newTitre.setTypeContrat(new TypeContrat());
			model.addAttribute("typeContrats",
					serviceTypeContrat.findAllOrderedByCode());
			model.addAttribute("societes", serviceSociete.findAll());
			model.addAttribute("newTitre", newTitre);
			model.addAttribute("userBean", userBean);
			return "membre/front/investisseur/Ajoutertitre";
		} catch (SmException e) {
			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
			return "/investisseur";
		}

	}

	@RequestMapping(value = "/Titre/ajout", method = RequestMethod.POST)
	public String ajoutTitre(
			@Valid @ModelAttribute("newTitre") Contrat newTitre,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		String message = "";

		if (!result.hasErrors()) {
			try {
				TypeContrat tc = serviceTypeContrat.findById(newTitre
						.getTypeContrat().getId());
				Investisseur inv = (Investisseur) serviceUser.findById(newTitre
						.getProprietaire().getId());
				Societe sc = serviceSociete.findById(newTitre.getSociete()
						.getId());
				newTitre.setProprietaire(inv);
				newTitre.setSociete(sc);
				newTitre.setTypeContrat(tc);
				serviceContrat.create(newTitre);
				message = "Enregistrement avec succès de la société: "
						+ newTitre.getCodeIsin();
			} catch (SmException e) {
				message = "Erreur d'enregistrement du Titre: "
						+ newTitre.getCodeIsin();
				logger.log(Level.SEVERE, e.getMessage(), e.getCause());
			}

		} else {
			message = "Erreur d'enregistrement du Titre: "
					+ newTitre.getCodeIsin();
			logger.log(Level.SEVERE, message);

		}
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/investisseur";
	}

}
