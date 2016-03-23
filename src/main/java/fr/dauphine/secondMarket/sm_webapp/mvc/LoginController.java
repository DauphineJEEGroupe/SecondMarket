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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.dauphine.secondMarket.sm_webapp.domain.User;
import fr.dauphine.secondMarket.sm_webapp.exception.SmException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmTechException;
import fr.dauphine.secondMarket.sm_webapp.mvc.bean.UserBean;
import fr.dauphine.secondMarket.sm_webapp.service.SecurityService;
import fr.dauphine.secondMarket.sm_webapp.utils.Constantes;
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

	// @Autowired
	// private UserBean userBean;

	private static final Logger logger = Logger.getLogger(LoginController.class
			.getCanonicalName());

	@RequestMapping(value = "public/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.info("index()");
		return "public/accueil";
	}

	@RequestMapping(value = "public/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request,
			HttpServletResponse response,Model model) {
		logger.info("login(): GET");
		try {
			UserBean userBean = UtilsSession.getUserBean(request);
			if (Constantes.ROLE_ADMIN.equals(userBean.getRole())) {
				return "redirect:/admin";
			} else if (Constantes.ROLE_INVESTISSEUR.equals(userBean.getRole())) {
				return "redirect:/investisseur";
			} else {
				return "redirect:/membreSociete";
			}
		} catch (SmException e) {
			model.addAttribute("login", new User());
			return "public/login";
		}
		

	}

	@RequestMapping(value = "public/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			HttpServletResponse response,
			@Valid @ModelAttribute("userBean") User login,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		logger.info("login(): POST");
		UserBean userBean = new UserBean();
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
			if (Constantes.ROLE_ADMIN.equals(userBean.getRole())) {
				return "redirect:/admin";
			} else if (Constantes.ROLE_INVESTISSEUR.equals(userBean.getRole())) {
				return "redirect:/investisseur";
			} else {
				return "redirect:/membreSociete";
			}

		} catch (SmTechException e) {
			redirectAttributes.addFlashAttribute("erreur",
					"L'email ou le mot de passe sont incorrects");
			logger.log(Level.SEVERE, e.getMessage(),e.getCause());
			return "redirect:/public/login";
		}

	}
	
	@RequestMapping(value = "public/logout", method = RequestMethod.GET)
	public String logout() {
		logger.info("logout(): GET");
		return "public/";

	}
}
