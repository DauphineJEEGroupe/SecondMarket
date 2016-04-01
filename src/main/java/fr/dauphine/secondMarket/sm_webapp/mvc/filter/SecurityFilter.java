package fr.dauphine.secondMarket.sm_webapp.mvc.filter;

import java.io.IOException;
import java.util.logging.Level;
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

import fr.dauphine.secondMarket.sm_webapp.exception.SmException;
import fr.dauphine.secondMarket.sm_webapp.mvc.bean.UserBean;
import fr.dauphine.secondMarket.sm_webapp.utils.Constantes;
import fr.dauphine.secondMarket.sm_webapp.utils.UtilsSession;

/**
 * Servlet Filter implementation class SecurityFilter
 * 
 * @author gnepa.rene.barou
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD }, description = "authentification filter", urlPatterns = { "/SecurityFilter" }, servletNames = { "jboss-as-kitchensink" })
public class SecurityFilter implements Filter {

	private static final Logger logger = Logger.getLogger(SecurityFilter.class
			.getCanonicalName());


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
		/* Cast des objets request et response */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		// /* Non-filtrage des ressources statiques */
		String chemin = request.getRequestURI().substring(
				request.getContextPath().length());
		if (chemin.trim().equalsIgnoreCase("/") || chemin.startsWith("/public/") || chemin.startsWith("/static/resources/")) {
			chain.doFilter(request, response);
			return;
		}
		UserBean userBean;
		try {
			userBean = UtilsSession.getUserBean(request);
			if (userBean.isConneted()) {
				UtilsSession.getSession(request).setAttribute(Constantes.ATT_SESSION_USER, userBean);
				chain.doFilter(request, response);
			} else {
				logger.info("NOT userBean.isConneted()");
				response.sendRedirect(request.getContextPath() + Constantes.ACCES_PUBLIC);
			}
		} catch (SmException e) {
			logger.log(Level.SEVERE,e.getMessage(),e.getCause());
			response.sendRedirect(request.getContextPath() + Constantes.ACCES_PUBLIC);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		logger.info("init filter");
	}

}
