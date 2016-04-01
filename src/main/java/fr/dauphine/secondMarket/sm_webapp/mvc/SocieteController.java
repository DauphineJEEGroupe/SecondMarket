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

import fr.dauphine.secondMarket.sm_webapp.domain.Societe;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmException;
import fr.dauphine.secondMarket.sm_webapp.service.SocieteService;

/**
 * @author gnepa.rene.barou
 *
 */
@Controller
@RequestMapping(value = "/societe")
public class SocieteController {
	@Autowired
	private SocieteService societeService;
	
	private static Logger logger=Logger.getLogger(SocieteController.class.getCanonicalName());

	
	@RequestMapping(value = "/search",method = RequestMethod.POST)
	public String search(@ModelAttribute("societe") Societe societe,Model model) {
		List<Societe> societes = new ArrayList<Societe>();
		try {
			societes = societeService.search(societe.getNom());
			model.addAttribute("societes", societes);
			model.addAttribute("societe", new Societe());
			return "membre/front/societe/listeSociete";
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
			return "redirect:/societe/list";
		}
		
	}
	@RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
	public String detail(@PathVariable Long id,Model model) {
		List<Societe> societes = new ArrayList<Societe>();
		try {
			Societe societeDetail = societeService.findById(id);
			societes = societeService.findAll();
			model.addAttribute("societes", societes);
			model.addAttribute("societeDetail", societeDetail);
			return "membre/front/societe/listeSociete";
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
			return "redirect:/societe/list";
		}
		
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Societe> societes = new ArrayList<Societe>();
		try {
			societes = societeService.findAll();
			model.addAttribute("societes", societes);
			model.addAttribute("societe", new Societe());
			return "membre/front/societe/listeSociete";
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
			return "redirect:/";
		}
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerNewSociete(
			@Valid @ModelAttribute("newSociete") Societe newSociete,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		String message = "";

		if (!result.hasErrors()) {
			try {
				societeService.create(newSociete);
				message = "Enregistrement avec succès de la société: "
						+ newSociete.getNom();
			} catch (SmException e) {
				message = "Erreur d'enregistrement de la société: "
						+ newSociete.getNom();
				logger.log(Level.SEVERE,e.getMessage(),e.getCause());
			}
			

		} else {
			// TODO error : List<ObjectError> errors = result.getAllErrors();
			message = "Erreur d'enregistrement de la société: "
					+ newSociete.getNom();
			
		}
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/societe";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editSocietePage(@PathVariable Long id, Model model,
			final RedirectAttributes redirectAttributes) {
		try {
			Societe societeToUpdate = societeService.findById(id);
			model.addAttribute("societeToUpdate", societeToUpdate);
			return "membre/back/societe-edit";
		} catch (SmDaoException e) {
			// TODO logger
			System.out.println("--------------ERROR---------"+e.getMessage());
			String message = "Erreur de modification de la société id: " + id;
			redirectAttributes.addFlashAttribute("message", message);
			return "redirect:/societe";
		}

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editSociete(
			@Valid @ModelAttribute("societeToUpdate") Societe societeToUpdate,
			BindingResult result) {
		if (!result.hasErrors()) {
			try {
				societeService.update(societeToUpdate);
			} catch (SmDaoException e) {
				// TODO logger SmDaoException
				System.out.println("--------------ERROR---------"+e.getMessage());
			}
		} else {
			System.out.println("------------------has error---------------");
			// TODO logger List<ObjectError> errors = result.getAllErrors();
		}
		return "redirect:/societe";

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteSociete(@PathVariable Long id) {

		try {
			societeService.delete(id);
		} catch (SmDaoException e) {
			// TODO logger SmDaoException
			System.out.println("--------------ERROR---------"+e.getMessage());
		}
		return "redirect:/societe";

	}

	@RequestMapping(value = "/accredit/{id}", method = RequestMethod.GET)
	public String accreditSociete(@PathVariable Long id) {

		try {
			societeService.accredit(societeService.findById(id));
		} catch (SmDaoException e) {
			// TODO logger SmDaoException
			System.out.println("--------------ERROR---------"+e.getMessage());
		}
		return "redirect:/societe";

	}

}
