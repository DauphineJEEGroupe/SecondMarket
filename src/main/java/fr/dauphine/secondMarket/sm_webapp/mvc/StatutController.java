/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.mvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dauphine.secondMarket.sm_webapp.domain.Statut;
import fr.dauphine.secondMarket.sm_webapp.repo.StatutDao;

/**
 * @author gnepa.rene.barou
 *
 */
@Controller
@RequestMapping(value = "/statut")
public class StatutController {
	@Autowired
	private StatutDao statutDao;

	@RequestMapping(method = RequestMethod.GET)
	public String displaySortedStatuts(Model model) {
		model.addAttribute("newStatut", new Statut());
		model.addAttribute("statuts", statutDao.findAllOrderedByName());
		return "back/statut";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerNewStatut(
			@Valid @ModelAttribute("newStatut") Statut newStatut,
			BindingResult result, Model model) {
		if (!result.hasErrors()) {
			statutDao.register(newStatut);
			return "redirect:/statut";
		} else {
			model.addAttribute("statuts", statutDao.findAllOrderedByName());
			return "back/statut";
		}
	}

}
