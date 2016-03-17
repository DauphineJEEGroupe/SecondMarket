/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dauphine.secondMarket.sm_webapp.domain.Contrat;
import fr.dauphine.secondMarket.sm_webapp.domain.Societe;
import fr.dauphine.secondMarket.sm_webapp.domain.User;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.mvc.bean.UserBean;
import fr.dauphine.secondMarket.sm_webapp.service.ContratService;
import fr.dauphine.secondMarket.sm_webapp.service.UserService;

/**
 *  @author gnepa.rene.barou
 *
 */
@Controller
@RequestMapping(value = "/titre")
public class ContratController {
	private static Logger logger = Logger
			.getLogger(ContratController.class.getCanonicalName());
	@Autowired
	UserService serviceUser;
	@Autowired
	ContratService serviceContrat;
	
	@RequestMapping(value = "/titre", method = RequestMethod.GET)
	public String list(Model model, @ModelAttribute("userBean") UserBean userBean) {
		
		try {
			List<Contrat> titres = serviceContrat
					.findByInvestisseur(userBean.getId());
			model.addAttribute("titres", titres);
			return "membre/front/contrat/list";
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
			return "redirect:/login";
		}
		
	}
	
	@RequestMapping(value = "/titre/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable Integer id,Model model) {
		
		try {
			Contrat titre = serviceContrat
					.findById(id);
			model.addAttribute("titre", titre);
			return "membre/front/contrat/detail";
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
			return "redirect:/login";
		}
		
	}
	
	@RequestMapping(value = "/titre/{id}", method = RequestMethod.GET)
	public String modifier(@PathVariable Integer id,Model model) {
		
		try {
			Contrat titre = serviceContrat
					.findById(id);
			model.addAttribute("titre", titre);
			return "membre/front/contrat/modif";
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
			return "redirect:/login";
		}
		
	}
}
