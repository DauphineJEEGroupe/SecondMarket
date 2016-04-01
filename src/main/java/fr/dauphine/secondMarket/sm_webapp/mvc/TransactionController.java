/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.mvc;

import java.util.ArrayList;
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
	ContratService serviceContrat;
	@Autowired
	ModeNegociationService serviceModeNegociation;
	@Autowired
	TypeTransactionService serviceTypeTransaction;

	@Autowired
	EtatTransactionService serviceEtatTransaction;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String mesTransactions(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			UserBean userBean = UtilsSession.getUserBean(request);
			transactions = serviceTransaction.findByVendeur(userBean.getId());
			model.addAttribute("transactions", transactions);
			model.addAttribute("userBean", userBean);
			model.addAttribute("search", new Transaction());
			return "membre/front/transaction/list";
		} catch (SmException e) {
			logger.severe(e.getMessage());
			return "/investisseur";
		}

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@ModelAttribute("search") Transaction search,
			Model model) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			transactions = serviceTransaction.search(search.getTitre()
					.getCodeIsin());
			model.addAttribute("transactions", transactions);
			model.addAttribute("search", new Transaction());
			return "membre/front/transaction/list";
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
			return "redirect:/investisseur";
		}

	}

	@RequestMapping(value = "/achat", method = RequestMethod.GET)
	public String listAchats(Model model,
			@ModelAttribute("userBean") UserBean userBean) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			transactions = serviceTransaction.findAllTransactionActif();
			model.addAttribute("transactions", transactions);
			model.addAttribute("search", new Transaction());
			return "membre/front/transaction/list";
		} catch (SmDaoException e) {
			logger.severe(e.getMessage());
			return "redirect:/public/login";
		}

	}

	@RequestMapping(value = "/societe/{id}", method = RequestMethod.GET)
	public String listBySociete(@PathVariable Long id, Model model,
			final RedirectAttributes redirectAttributes) {

		try {
			List<Transaction> transactions = serviceTransaction
					.findBySociete(id);
			model.addAttribute("transactions", transactions);
			model.addAttribute("search", new Transaction());
			return "membre/front/transaction/list";
		} catch (SmDaoException e) {
			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
			return "/investisseur";
		}

	}

	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable Long id, Model model,
			final RedirectAttributes redirectAttributes) {

		try {
			Transaction transaction = serviceTransaction.findById(id);
			model.addAttribute("transaction", transaction);
			if (Constantes.CODE_NEGOCIATION_ENCHERE
					.equalsIgnoreCase(transaction.getModeNegociation()
							.getCode())) {
				return "membre/front/transaction/detail-enchere";
			} else {
				return "membre/front/transaction/detail";
			}

		} catch (SmDaoException e) {
			String erreur = "Aucune transaction de trouver pour l'id: " + id;
			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
			redirectAttributes.addFlashAttribute("erreur", erreur);
			return "redirect:/transaction/achat";
		}

	}

	/**
	 * Acheter un titre
	 * 
	 * @param request
	 * @param response
	 * @param transaction
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/achat", method = RequestMethod.POST)
	public String achat(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("transaction") Transaction transaction,
			Model model, final RedirectAttributes redirectAttributes) {

		try {

			UserBean userBean = UtilsSession.getUserBean(request);
			Transaction achat = serviceTransaction
					.findById(transaction.getId());
			achat.setAcheteur((Investisseur) serviceUser.findById(userBean
					.getId()));
			if(achat.getModeNegociation().getCode().equalsIgnoreCase(Constantes.CODE_NEGOCIATION_ENCHERE)){
				achat.setPrixCloture(transaction.getPrixCloture());
			}
			
			serviceTransaction.achat(achat);
			return "redirect:/investisseur";
		} catch (SmException e) {
			String erreur = "Aucune transaction de trouver pour l'id: "
					+ transaction.getId();
			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
			redirectAttributes.addFlashAttribute("erreur", erreur);
			return "redirect:/transaction/achat";
		}

	}

	/**
	 * Vendre un titre
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
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
			newtransaction.setQuantite(1L);
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
		Transaction transaction = new Transaction();
		try {
			serviceContrat.hasEnoughTitreToSale(newtransaction.getTitre()
					.getId(), newtransaction.getQuantite());
			transaction.setActif(true);
			transaction.setDateDebut(new Date());
			// TODO jodaTime pour ajout 1j a getDateDebut
			// transaction.setDateCloture(newtransaction.getDateCloture().after(newtransaction.getDateDebut())?
			// newtransaction.getDateCloture() : newtransaction.getDateDebut());
			transaction.setDateCloture(newtransaction.getDateCloture());
			transaction.setQuantite(newtransaction.getQuantite());
			transaction.setEtatTransaction(serviceEtatTransaction
					.findByCode(Constantes.CODE_TRANSACTION_OUVERTE));
			transaction.setModeNegociation(serviceModeNegociation
					.findById(newtransaction.getModeNegociation().getId()));
			transaction.setPrixOuverture(newtransaction.getPrixOuverture());
			if (Constantes.CODE_NEGOCIATION_IMMEDIAT
					.equalsIgnoreCase(newtransaction.getModeNegociation()
							.getCode())
					|| newtransaction.getPrixCloture() < newtransaction
							.getPrixOuverture()) {
				transaction.setPrixCloture(newtransaction.getPrixOuverture());
			} else {
				transaction.setPrixCloture(newtransaction.getPrixCloture());
			}
			transaction.setPrixTransaction(transaction.getPrixCloture()
					* transaction.getQuantite());
			Contrat titre = serviceContrat.findById(newtransaction.getTitre()
					.getId());
			transaction.setTitre(titre);
			transaction.setTypeTransaction(serviceTypeTransaction
					.findByCode(Constantes.CODE_TRANSACTION_VENTE));

			Investisseur vendeur = (Investisseur) serviceUser
					.findById(newtransaction.getVendeur().getId());
			transaction.setVendeur(vendeur);

			serviceTransaction.create(transaction);

			serviceContrat.vendre(titre, transaction.getQuantite());

			String message = "Transaction effectuée avec succes";
			redirectAttributes.addFlashAttribute("message", message);
			return "redirect:/investisseur";
		} catch (SmException e) {
			String erreur = "Echec de la transaction: "
					+ newtransaction.getId();
			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
			redirectAttributes.addFlashAttribute("erreur", erreur);
			return "redirect:/investisseur";
		}

	}

}
