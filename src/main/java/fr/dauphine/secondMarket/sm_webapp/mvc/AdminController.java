/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.dauphine.secondMarket.sm_webapp.domain.MembreSociete;
import fr.dauphine.secondMarket.sm_webapp.domain.Societe;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmException;
import fr.dauphine.secondMarket.sm_webapp.service.SocieteService;
import fr.dauphine.secondMarket.sm_webapp.utils.Constantes;
import fr.dauphine.secondMarket.sm_webapp.utils.Utils;

/**
 * @author gnepa.rene.barou
 *
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	SocieteService societeService;
	
	private static final Logger logger = Logger.getLogger(AdminController.class
			.getCanonicalName());

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {

		return "membre/back/admin/acceuil";
	}

	@RequestMapping(value = "/societe", method = RequestMethod.GET)
	public String societe(Model model) {
		List<Societe> societes = new ArrayList<Societe>();
		try {
			societes = societeService.findAll();
			model.addAttribute("societes", societes);
			model.addAttribute("societe", new Societe());
			return "membre/back/admin/societe";
		} catch (SmDaoException e) {
			logger.log(Level.SEVERE, e.getMessage(),e.getCause());
			return "redirect:/admin";
		}
	}

	@RequestMapping(value = "/societe/accrediter/{id}", method = RequestMethod.GET)
	public String accrediter(@PathVariable Long id, Model model,final RedirectAttributes redirectAttributes) {
		try {
			logger.info("/societe/detail/{id}");
			Societe societe = societeService.findById(id);
			model.addAttribute("societe", societe);
			model.addAttribute("representant", new MembreSociete());
			return "membre/back/admin/accrediter";
		} catch (SmDaoException e) {
			String erreur = Utils.errorStringBuilder("Une erreur s'est produite");
			logger.log(Level.SEVERE, e.getMessage(),e.getCause());
			model.addAttribute("erreur", erreur.toString());
			redirectAttributes.addAttribute("erreur", erreur.toString());
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value = "/societe/accrediter", method = RequestMethod.POST)
	public String accrediter(@Valid @ModelAttribute("representant") MembreSociete representant,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		logger.info("accrediter()");
		if (result.hasErrors()) {
			String erreur = Utils.errorsStringBuilder(result);
			model.addAttribute("erreur", erreur.toString());
			logger.severe(erreur.toString());
			model.addAttribute("societe", representant.getSociete());
			model.addAttribute("representant", representant);
			return "membre/back/admin/accrediter";
		} 
//		else {representant.setSociete(societeService.findById(representant.getSociete().getId()));
		try {
			Utils.validationEmail(representant.getEmail());
			Utils.validationMotsDePasse(representant.getPass(), representant.getPass2());
			Utils.validationNom(representant.getNom());
		} catch (SmException e1) {
			model.addAttribute("representant", representant);
			model.addAttribute("erreur", Utils.errorStringBuilder(e1.getMessage()));
			model.addAttribute("societe", representant.getSociete());
			logger.severe(Utils.errorStringBuilder(e1.getMessage()).toString());
			return "membre/back/admin/accrediter";
		}

		try {
			Societe societe=societeService.findById(representant.getSociete().getId());
			MembreSociete newUser = new MembreSociete();
			newUser.setNom(representant.getNom());
			newUser.setPhoneNumber(representant.getPhoneNumber());
			newUser.setPrenom(representant.getNom());
			newUser.setEmail(representant.getEmail());
			newUser.setActif(true);
			newUser.setPass(representant.getPass());
			newUser.setRole(Constantes.ROLE_MEMBRE_SOCIETE_CODE);
			newUser.setSociete(societe);
			
			societe.setRepresentant(representant);
			societeService.accredit(societe);
			redirectAttributes.addFlashAttribute("message", Utils.msgStringBuilder("Succès d'accréditation").toString());
			return "redirect:/admin/societe";
		} catch (SmException e) {
			logger.severe(e.getMessage());
			redirectAttributes.addFlashAttribute("erreur", Utils.errorStringBuilder("Erreur d'accréditation").toString());
			return "redirect:/admin/societe";
		}
	}

	@RequestMapping(value = "/societe/new", method = RequestMethod.GET)
	public String newSociete(Model model) {
		model.addAttribute("societe", new Societe());
		return "membre/back/admin/societeNew";
	}

	@RequestMapping(value = "/societe/new", method = RequestMethod.POST)
	public String newSociete(@Valid @ModelAttribute("societe") Societe societe,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		String message = "";

		if (!result.hasErrors()) {
			try {
				societeService.create(societe);
				message = "Enregistrement avec succès de la société: "
						+ societe.getNom();
			} catch (SmException e) {
				message = "Erreur d'enregistrement de la société: "
						+ societe.getNom();
				logger.log(Level.SEVERE, e.getMessage(), e.getCause());
			}

		} else {
			message = "Erreur d'enregistrement de la société: "
					+ societe.getNom();

		}
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/admin/societe";
	}

	@RequestMapping(value = "/societe/search", method = RequestMethod.POST)
	public String search(@ModelAttribute("societe") Societe societe, Model model) {
		List<Societe> societes = new ArrayList<Societe>();
		try {
			societes = societeService.search(societe.getNom());
			model.addAttribute("societes", societes);
			model.addAttribute("societe", new Societe());
			return "membre/back/admin/societe";
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
			return "redirect:/admin";
		}

	}

	@RequestMapping(value = "/societe/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable Long id, Model model) {
		List<Societe> societes = new ArrayList<Societe>();
		try {
			logger.info("/societe/detail/{id}");
			Societe societeDetail = societeService.findById(id);
			societes = societeService.findAll();
			model.addAttribute("societes", societes);
			model.addAttribute("societe", new Societe());
			model.addAttribute("societeDetail", societeDetail);
			return "membre/back/admin/societe";
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
			return "redirect:/admin";
		}

	}
}
