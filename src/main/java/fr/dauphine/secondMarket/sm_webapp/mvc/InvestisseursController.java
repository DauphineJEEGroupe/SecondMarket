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
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dauphine.secondMarket.sm_webapp.domain.User;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.service.UserService;
import fr.dauphine.secondMarket.sm_webapp.utils.Constantes;

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

//	public String showAllInvestisseurs(Model model) {  addInvestisseurForm.jsp
//		List<User> investisseurs = new ArrayList<User>();
//
//		try {
//			investisseurs = serviceUser
//					.findByType(Constantes.TYPE_USER_INVESTISSEUR);
//		} catch (SmDaoException e) {
//			logger.severe(e.getMessage());
//		}
//		logger.info("showAllInvestisseurs()");
//		model.addAttribute("investisseurs", investisseurs);
//		return "back/investisseur/list";
//
//	}

}
