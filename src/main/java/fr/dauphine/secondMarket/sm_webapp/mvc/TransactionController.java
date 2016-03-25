/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import fr.dauphine.secondMarket.sm_webapp.domain.Investisseur;
import fr.dauphine.secondMarket.sm_webapp.domain.Transaction;
import fr.dauphine.secondMarket.sm_webapp.exception.SmDaoException;
import fr.dauphine.secondMarket.sm_webapp.exception.SmException;
import fr.dauphine.secondMarket.sm_webapp.mvc.bean.UserBean;
import fr.dauphine.secondMarket.sm_webapp.service.ContratService;
import fr.dauphine.secondMarket.sm_webapp.service.EtatTransactionService;
import fr.dauphine.secondMarket.sm_webapp.service.ModeNegociationService;
import fr.dauphine.secondMarket.sm_webapp.service.SocieteService;
import fr.dauphine.secondMarket.sm_webapp.service.TransactionService;
import fr.dauphine.secondMarket.sm_webapp.service.TypeTransactionService;
import fr.dauphine.secondMarket.sm_webapp.service.UserService;
import fr.dauphine.secondMarket.sm_webapp.utils.Constantes;
import fr.dauphine.secondMarket.sm_webapp.utils.UtilsSession;

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
	@Autowired
	UserService serviceUser;
	@Autowired
	SocieteService serviceSociete;
	@Autowired
	ContratService serviceContrat;
	@Autowired
	ModeNegociationService serviceModeNegociation;
	@Autowired
	TypeTransactionService serviceTypeTransaction;

	@Autowired
	EtatTransactionService serviceEtatTransaction;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAchats(HttpServletRequest request,
			HttpServletResponse response,Model model) {

		try {
			UserBean userBean = UtilsSession.getUserBean(request);
			List<Transaction> transactions = serviceTransaction
					.findByVendeur(userBean.getId());
			model.addAttribute("transactions", transactions);
			model.addAttribute("userBean", userBean);
			return "membre/front/transaction/list";
		} catch (SmException e) {
			logger.severe(e.getMessage());
			return "/investisseur";
		}

	}

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
			return "redirect:/public/login";
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
	public String vendre(HttpServletRequest request,
			HttpServletResponse response, @PathVariable Long id, Model model,
			final RedirectAttributes redirectAttributes) {

		try {
			UserBean userBean = UtilsSession.getUserBean(request);
			Contrat titre = serviceTransaction.findByTitreForSale(id);
			model.addAttribute("titre", titre);
			Transaction newtransaction = new Transaction();
			newtransaction.setTitre(titre);
			newtransaction.setPrixCloture(1L);
			newtransaction.setPrixOuverture(1L);
			newtransaction.setQuantite(1);
			newtransaction.setVendeur((Investisseur) serviceUser
					.findById(userBean.getId()));
			model.addAttribute("newtransaction", newtransaction);
			model.addAttribute("modeNegociations",
					serviceModeNegociation.findAllOrderedByCode());
			return "membre/front/investisseur/vendretitre";
		} catch (SmException e) {
			logger.severe(e.getMessage());
			String erreur = "Aucun titre de trouver pour l'id: " + id;
			redirectAttributes.addFlashAttribute("erreur", erreur);
			return "redirect:/investisseur";
		}

	}

	@RequestMapping(value = "/vendre/{id}", method = RequestMethod.POST)
	public String vendre(
			@Valid @ModelAttribute("newtransaction") Transaction newtransaction,
			BindingResult result, final RedirectAttributes redirectAttributes) {

		try {
			newtransaction.setActif(true);
			newtransaction.setDateDebut(new Date());
			newtransaction.setEtatTransaction(serviceEtatTransaction
					.findByCode(Constantes.CODE_TRANSACTION_OUVERTE));
			newtransaction.setModeNegociation(serviceModeNegociation
					.findById(newtransaction.getModeNegociation().getId()));
			if (Constantes.CODE_NEGOCIATION_IMMEDIAT
					.equalsIgnoreCase(newtransaction.getModeNegociation()
							.getCode())
					|| newtransaction.getPrixCloture() < newtransaction
							.getPrixOuverture()) {
				newtransaction
						.setPrixCloture(newtransaction.getPrixOuverture());
			}
			newtransaction.setTitre(serviceContrat.findById(newtransaction.getTitre().getId()));
			newtransaction.setTypeTransaction(serviceTypeTransaction.findByCode(Constantes.CODE_TRANSACTION_VENTE));
			newtransaction.setVendeur((Investisseur) serviceUser
					.findById(newtransaction.getVendeur().getId()));
			serviceTransaction.create(newtransaction);
			String message = "Transaction effectuée avec succes";
			redirectAttributes.addFlashAttribute("message", message);
			return "redirect:/achat";
		} catch (SmDaoException e) {
			String erreur = "Echec de la transaction: "
					+ newtransaction.getId();
			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
			redirectAttributes.addFlashAttribute("erreur", erreur);
			return "redirect:/achat";
		}

	}
}
