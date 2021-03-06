package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dauphine.secondMarket.sm_webapp.domain.User;
import fr.dauphine.secondMarket.sm_webapp.exception.SmException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmTechException;
import fr.dauphine.secondMarket.sm_webapp.mvc.bean.UserBean;
import fr.dauphine.secondMarket.sm_webapp.service.SecurityService;
import fr.dauphine.secondMarket.sm_webapp.service.TransactionService;
import fr.dauphine.secondMarket.sm_webapp.utils.Constantes;
import fr.dauphine.secondMarket.sm_webapp.utils.Utils;
import fr.dauphine.secondMarket.sm_webapp.utils.UtilsSession;
/**
 * @author gnepa.rene.barou
 *
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

	@Autowired
	private SecurityService securityService;

	@Autowired
	private TransactionService serviceTransaction;

	private static final Logger logger = Logger.getLogger(LoginController.class
			.getCanonicalName());
	@RequestMapping( method = RequestMethod.GET)
	public String index(Model model) {
		return "public/index";
	}
	@RequestMapping(value = "public/", method = RequestMethod.GET)
	public String publicIndex(Model model) {
		return "public/index";
	}
	@RequestMapping(value = "accueil/", method = RequestMethod.GET)
	public String accueil(Model model) {
		return "membre/accueil";
	}

	@RequestMapping(value = "public/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request,
			HttpServletResponse response,Model model) {
		try {
			UserBean userBean = new UserBean();//UtilsSession.getUserBean(request);
			
			User user = securityService.getAuthenticateUser("admin@secondMarket.com",
					"admin");
			userBean.setEmail(user.getEmail());
			userBean.setUsername(user.getNom());
			userBean.setRole(securityService.getRole(user.getRole()));
			userBean.setConneted(true);
			userBean.setId(user.getId());
			logger.info("Connexion de: " + userBean.getEmail() + " is conected: "
					+ userBean.isConneted());
			HttpSession session = request.getSession();
			session.setAttribute(Constantes.ATT_SESSION_USER, userBean);
			serviceTransaction.checkEnchereToClose();
			if (Constantes.ROLE_ADMIN.equals(userBean.getRole())) {
				return "redirect:/admin";
			} else if (Constantes.ROLE_INVESTISSEUR.equals(userBean.getRole())) {
				return "redirect:/investisseur";
			} else {
				return "redirect:/membreSociete";
			}
		} catch (SmException e) {
			logger.info("identification");
			model.addAttribute("login", new User());
			return "public/identification";
		}
		

	}
	

	@RequestMapping(value = "public/login", method = RequestMethod.POST)
	public String connection(HttpServletRequest request,
			HttpServletResponse response,
			@Valid @ModelAttribute("login") User login,Model model,
			BindingResult result) {
		logger.info("login(): POST");
		UserBean userBean = new UserBean();
		if (result.hasErrors()) {
			String erreur = Utils.errorsStringBuilder(result);
			logger.log(Level.SEVERE, erreur.toString());
			model.addAttribute("erreur", erreur.toString());
			model.addAttribute("login", login);
			return "public/identification";
		}
		try {
			User user = securityService.getAuthenticateUser(login.getEmail(),
					login.getPass());
			userBean.setEmail(user.getEmail());
			userBean.setUsername(user.getNom());
			userBean.setRole(securityService.getRole(user.getRole()));
			userBean.setConneted(true);
			userBean.setId(user.getId());
			logger.info("Connexion de: " + userBean.getEmail() + " is conected: "
					+ userBean.isConneted());
			HttpSession session = request.getSession();
			session.setAttribute(Constantes.ATT_SESSION_USER, userBean);
			serviceTransaction.checkEnchereToClose();
			if (Constantes.ROLE_ADMIN.equals(userBean.getRole())) {
				return "redirect:/admin";
			} else if (Constantes.ROLE_INVESTISSEUR.equals(userBean.getRole())) {
				return "redirect:/investisseur";
			} else {
				return "redirect:/membreSociete";
			}

		} catch (SmTechException e) {
			String erreur = Utils.errorStringBuilder("L'email ou le mot de passe sont incorrects");
			logger.log(Level.SEVERE, e.getMessage(),e.getCause());
			model.addAttribute("erreur", erreur.toString());
			model.addAttribute("login", login);
			return "public/identification";
		}

	}
	
	@RequestMapping(value = "public/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			UserBean userBean=UtilsSession.getUserBean(request);
			userBean.logout();
			UtilsSession.getSession(request).invalidate();
		} catch (SmException e) {
			logger.log(Level.SEVERE, e.getMessage(),e.getCause());
		}
		return "redirect:/";

	}
}
