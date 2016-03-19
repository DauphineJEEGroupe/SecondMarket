/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.dauphine.secondMarket.sm_webapp.domain.Contrat;
import fr.dauphine.secondMarket.sm_webapp.domain.Transaction;
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

	private static Logger logger = Logger.getLogger(TransactionController.class
			.getCanonicalName());

	@Autowired
	private TransactionService serviceTransaction;

	@RequestMapping(value = "/achat", method = RequestMethod.GET)
	public String listAchats(Model model,
			@ModelAttribute("userBean") UserBean userBean) {

		try {
			List<Transaction> transactions = serviceTransaction
					.findAllTransactionActif();
			model.addAttribute("transactions", transactions);
			return "membre/front/transaction/list";
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
			return "redirect:/login";
		}

	}

	@RequestMapping(value = "/achat/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable Long id, Model model,
			final RedirectAttributes redirectAttributes) {

		try {
			Transaction transaction = serviceTransaction.findById(id);
			model.addAttribute("transaction", transaction);
			return "membre/front/transaction/detail";
		} catch (SmDaoException e) {
			String erreur = "Aucune transaction de trouver pour l'id: " + id;
			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
			redirectAttributes.addFlashAttribute("erreur", erreur);
			return "redirect:/achat";
		}

	}

	@RequestMapping(value = "/achat", method = RequestMethod.POST)
	public String achat(
			@Valid @ModelAttribute("transaction") Transaction transaction,
			BindingResult result, final RedirectAttributes redirectAttributes) {

		try {
			serviceTransaction.update(transaction);
			String message = "Transaction effectuée avec succes";
			redirectAttributes.addFlashAttribute("message", message);
			return "redirect:/achat";
		} catch (SmDaoException e) {
			String erreur = "Echec de la transaction: " + transaction.getId();
			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
			redirectAttributes.addFlashAttribute("erreur", erreur);
			return "redirect:/achat";
		}

	}
	
	@RequestMapping(value = "/vendre/{id}", method = RequestMethod.GET)
	public String vendre(@PathVariable Long id, Model model,
			@ModelAttribute("userBean") UserBean userBean, final RedirectAttributes redirectAttributes) {

		try {
			Contrat titre = serviceTransaction
					.findByTitreForSale(id);
			model.addAttribute("titre", titre);
			model.addAttribute("transaction", new Transaction());
			return "membre/front/transaction/transtactionForm";
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
			String erreur = "Aucun titre de trouver pour l'id: " + id;
			redirectAttributes.addFlashAttribute("erreur", erreur);
			return "redirect:/investisseur";
		}

	}
	
	@RequestMapping(value = "/vendre", method = RequestMethod.POST)
	public String vendre(
			@Valid @ModelAttribute("transaction") Transaction transaction, @Valid @ModelAttribute("titre") Contrat titre,
			BindingResult result, final RedirectAttributes redirectAttributes) {

//		try {
//			serviceTransaction.create(transaction, idInvestisseur, prixInitial, prixFinal, transaction);;
//			String message = "Transaction effectuée avec succes";
//			redirectAttributes.addFlashAttribute("message", message);
			return "redirect:/achat";
//		} catch (SmDaoException e) {
//			String erreur = "Echec de la transaction: " + transaction.getId();
//			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
//			redirectAttributes.addFlashAttribute("erreur", erreur);
//			return "redirect:/achat";
//		}

	}
}
