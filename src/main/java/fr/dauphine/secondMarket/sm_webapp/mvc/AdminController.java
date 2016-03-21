/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author gnepa.rene.barou
 *
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	private static final Logger logger = Logger.getLogger(AdminController.class
			.getCanonicalName());

	@RequestMapping( method = RequestMethod.GET)
	public String main(Model model) {
		logger.info("index()");
		
		return "membre/back/admin/main";
	}

}
