/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author gnepa.rene.barou
 * 
 * Permet de tester les vues en affichage
 * A utiliser seulement pour des tests
 *
 */
@Controller
@RequestMapping(value = "/testView")
public class TestView {

	/**
	 * 
	 */
	public TestView() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String login(Model model) {
		
		return "back/accueil";

	}

}
