/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.util.List;
import java.util.logging.Level;
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
	ContratService serviceContrat;

	@RequestMapping(method = RequestMethod.GET)
	public String main(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		logger.info("main()");

		try {
			UserBean userBean = UtilsSession.getUserBean(request);
			Investisseur investisseur = (Investisseur) serviceUser
					.findById(userBean.getId());
			List<Contrat> titres = serviceContrat
					.findByInvestisseur(investisseur.getId());
			model.addAttribute("titres", titres);
			model.addAttribute("investisseur", investisseur);
			model.addAttribute("userBean", userBean);
			return "membre/front/investisseur/main";
		} catch (SmDaoException e) {
			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
			return "redirect:/public/login";
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
			return "redirect:/public/login";
		}

	}

}
