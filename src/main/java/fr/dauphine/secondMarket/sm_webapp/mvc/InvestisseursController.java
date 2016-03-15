/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dauphine.secondMarket.sm_webapp.domain.Contrat;
import fr.dauphine.secondMarket.sm_webapp.domain.Investisseur;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.mvc.bean.UserBean;
import fr.dauphine.secondMarket.sm_webapp.service.ContratService;
import fr.dauphine.secondMarket.sm_webapp.service.UserService;

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
	ContratService serviceContrat;

	@RequestMapping(method = RequestMethod.GET)
	public String displayInvestisseur(HttpServletRequest request,
			HttpServletResponse response, UserBean userBean, Model model) {

		logger.info("displayInvestisseur()");

		try {
			Investisseur investisseur = (Investisseur) serviceUser
					.findById(userBean.getId());
			List<Contrat> titres = serviceContrat
					.findByInvestisseur(investisseur.getId());
			model.addAttribute("titres", titres);
			model.addAttribute("investisseur", investisseur);
			return "front/investisseur/monProfil";
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
			return "redirect:/login";
		}

	}

}
