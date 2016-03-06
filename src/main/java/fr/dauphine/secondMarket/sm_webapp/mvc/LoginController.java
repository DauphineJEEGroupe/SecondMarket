package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import fr.dauphine.secondMarket.sm_webapp.exception.SmTechException;
import fr.dauphine.secondMarket.sm_webapp.service.SecurityService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserBean userBean;
	private static Logger logger = Logger.getLogger(LoginController.class
			.getCanonicalName());

	@RequestMapping(method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("userBean", userBean);
		return "login";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			HttpServletResponse response,
			@Valid @ModelAttribute("login") UserBean userBean,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		try {
			User user = securityService.getAuthenticateUser(
					userBean.getEmail(), userBean.getPassword());
			this.userBean.setEmail(user.getEmail());
			this.userBean.setUsername(user.getNom());
			this.userBean.setRole(securityService.getRole(user.getRole()));
			this.userBean.setConneted(true);
			logger.info("Connexion de: " + userBean.getEmail() + " / "
					+ userBean.getPassword());

			return "redirect:/user";
		} catch (SmTechException e) {
			redirectAttributes.addFlashAttribute("erreur",
					"L'email et le mot de passe sont obligatoire");
			logger.severe("L'email et le mot de passe sont obligatoire");
			return "redirect:/login";
		}

	}
}
