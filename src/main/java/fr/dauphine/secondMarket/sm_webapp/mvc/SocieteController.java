/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.dauphine.secondMarket.sm_webapp.domain.Societe;
import fr.dauphine.secondMarket.sm_webapp.domain.Statut;
import fr.dauphine.secondMarket.sm_webapp.repo.SocieteDao;
import fr.dauphine.secondMarket.sm_webapp.repo.StatutDao;
import fr.dauphine.secondMarket.sm_webapp.utils.Constantes;

/**
 * @author gnepa.rene.barou
 *
 */
@Controller
@RequestMapping(value = "/societe")
public class SocieteController {
	@Autowired
	private SocieteDao societeDao;
	@Autowired
	private StatutDao statutDao;

	@RequestMapping(method = RequestMethod.GET)
	public String displaySortedSocietes(Model model) {
		model.addAttribute("newSociete", new Societe());
		model.addAttribute("societes", societeDao.findAllOrderedByName());
		return "back/societe";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerNewSociete(
			@Valid @ModelAttribute("newSociete") Societe newSociete,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		String message = "";

		if (!result.hasErrors()) {
			Statut statut = statutDao.findByName(Constantes.STATUT_REFERENCEE);
			newSociete.setStatut(statut);
			societeDao.register(newSociete);
			redirectAttributes.addFlashAttribute("message", message);
			return "redirect:/societe";
		} else {
			System.out.println("------------------has error---------------");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError objectError : errors) {
				System.out.println(objectError.toString());
			}
			model.addAttribute("societes", societeDao.findAllOrderedByName());
			redirectAttributes.addFlashAttribute("message", message);
			return "back/societe";
		}
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editSocietePage(@PathVariable Integer id, Model model) {
		Societe societeToUpdate = societeDao.findById(id);
		model.addAttribute("societeToUpdate", societeToUpdate);
		return "back/societe-edit";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editSociete(
			@Valid @ModelAttribute("societeToUpdate") Societe societeToUpdate,
			BindingResult result) {
		if (!result.hasErrors()) {
			societeDao.update(societeToUpdate);
//			return "redirect:/societe";
		} else {
			System.out.println("------------------has error---------------");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError objectError : errors) {
				System.out.println(objectError.toString());
			}
//			model.addAttribute("societes", societeDao.findAllOrderedByName());
//			return "back/societe";
		}
		return "redirect:/societe";
		
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteSociete(@PathVariable Integer id) {
			societeDao.delete(id);
			return "redirect:/societe";
		
		
	}
	@RequestMapping(value = "/accredit/{id}", method = RequestMethod.GET)
	public String accreditSociete(@PathVariable Integer id) {
		Societe societeToUpdate=societeDao.findById(id);
		Statut statut = statutDao.findByName(Constantes.STATUT_ACCREDITEE);
		societeToUpdate.setStatut(statut);
		societeDao.update(societeToUpdate);
		return "redirect:/societe";
		
	}

}
