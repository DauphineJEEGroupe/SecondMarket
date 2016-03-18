/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dauphine.secondMarket.sm_webapp.domain.Contrat;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.mvc.bean.UserBean;
import fr.dauphine.secondMarket.sm_webapp.service.TransactionService;

/**
 * @author gnepa.rene.barou
 *
 */
@Controller
@RequestMapping(value = "/transaction")
public class TransactionController {

	private static Logger logger=Logger.getLogger(TransactionController.class.getCanonicalName());
	@Autowired
	private TransactionService serviceTransaction;
	@RequestMapping(value = "/titre", method = RequestMethod.GET)
	public String listAchats(Model model,
			@ModelAttribute("userBean") UserBean userBean) {

		try {
			List<Contrat> titres = serviceContrat.findByInvestisseur(userBean
					.getId());
			model.addAttribute("titres", titres);
			return "membre/front/contrat/list";
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
			return "redirect:/login";
		}

	}
}
