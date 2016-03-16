package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.dauphine.secondMarket.sm_webapp.domain.Investisseur;
import fr.dauphine.secondMarket.sm_webapp.domain.User;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmTechException;
import fr.dauphine.secondMarket.sm_webapp.service.UserService;
import fr.dauphine.secondMarket.sm_webapp.utils.Constantes;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	Logger logger=Logger.getLogger(UserController.class.getCanonicalName());
	
	@Autowired
	private UserService userService;
	
	public UserController() {
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayUser(Model model){
		logger.info("displayUser()");
		List<User> users=new ArrayList<User>();
		try {
			users=userService.findAll();
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
		}
		model.addAttribute("users", users);
		model.addAttribute("newUser", new User());
		return "membre/back/user/list";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerNewUser(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		logger.info("registerNewUser()");
		if(result.hasErrors()){
			StringBuilder erreur=new StringBuilder();
			for (ObjectError error : result.getAllErrors()) {
				erreur.append(error.getObjectName()+"---"+ error.getDefaultMessage() + " \n ---");
			}
			redirectAttributes.addFlashAttribute("erreur",erreur.toString());
		}else{
			newUser.setActif(true);
			newUser.setPass(newUser.getNom());
			newUser.setRole(1);
			try {
				userService.create(newUser);
				redirectAttributes.addFlashAttribute("message","Enregistrement avec succes de "+newUser.getNom());
			} catch (SmException e) {
				logger.severe(e.getMessage());
				redirectAttributes.addFlashAttribute("erreur",e.getMessage());
			} 
		}
		
		
		return "redirect:/user";
		
	}
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String newInvestisseurForm(Model model) {
		logger.info("newInvestisseurForm(): GET");
		model.addAttribute("newInvestisseur", new Investisseur());
		return "public/inscriptionForm";
	}
	
	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public String registerNewInvestisseur(
			@Valid @ModelAttribute("newInvestisseur") Investisseur newInvestisseur,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		logger.info("registerNewInvestisseur()");
		if(result.hasErrors()){
			StringBuilder erreur=new StringBuilder();
			for (ObjectError error : result.getAllErrors()) {
				erreur.append(error.getObjectName()+"---"+ error.getDefaultMessage() + " \n ---");
			}
			model.addAttribute("erreur",erreur.toString());
			model.addAttribute("newInvestisseur", newInvestisseur);
			return "public/inscriptionForm";
		}else{
			Investisseur newUser= new Investisseur();
			newUser.setActif(true);
			newUser.setPass(newInvestisseur.getNom());
			newUser.setRole(Constantes.ROLE_INVESTISSEUR_CODE);
			newUser.setProfilInvestisseur("");
			
			try {
				userService.create(newUser);
			} catch (SmDaoException | SmTechException e) {
				logger.severe(e.getMessage());
				redirectAttributes.addFlashAttribute("erreur",e.getMessage());
			}
		}
		
		return "redirect:/login";
		
		
	}

}
