package fr.dauphine.secondMarket.sm_webapp.mvc.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dauphine.secondMarket.sm_webapp.mvc.bean.UserBean;
import fr.dauphine.secondMarket.sm_webapp.utils.Constantes;

/**
 * Servlet Filter implementation class SecurityFilter
 * 
 * @author gnepa.rene.barou
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD }, description = "authentification filter", urlPatterns = { "/SecurityFilter" }, servletNames = { "jboss-as-kitchensink" })
public class SecurityFilter implements Filter {

	private static final Logger logger = Logger.getLogger(SecurityFilter.class
			.getCanonicalName());

//	@Autowired
//	private UserBean userBean;

	/**
	 * Default constructor.
	 */
	public SecurityFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		logger.info("*****************SecurityFilter doFilter()");
		/* Cast des objets request et response */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();
		// /* Non-filtrage des ressources statiques */
		String chemin = request.getRequestURI().substring(
				request.getContextPath().length());
		if (chemin.startsWith("/public/")) {
			chain.doFilter(request, response);
			return;
		}
		/**
		 * Si l'objet utilisateur n'existe pas dans la session en cours, alors
		 * l'utilisateur n'est pas connecté.
		 */
		if (session.getAttribute(Constantes.ATT_SESSION_USER) == null) {
			logger.info("SecurityFilter ( ATT_SESSION_USER ) == null");
			/* Redirection vers la page publique */
			response.sendRedirect(request.getContextPath() + Constantes.ACCES_PUBLIC);
		} else {
			UserBean userBean = (UserBean) session
					.getAttribute(Constantes.ATT_SESSION_USER);
			if (userBean.isConneted()) {
				logger.info(" SecurityFilter userBean.isConneted()");
				/* Affichage de la page restreinte */
				chain.doFilter(request, response);
			} else {
				logger.info(" SecurityFilter userBean.isNOTConneted()");
				response.sendRedirect(request.getContextPath() + Constantes.ACCES_PUBLIC);
			}

		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("init filter");
	}

}
