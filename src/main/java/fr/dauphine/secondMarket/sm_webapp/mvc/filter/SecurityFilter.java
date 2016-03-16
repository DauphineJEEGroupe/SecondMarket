package fr.dauphine.secondMarket.sm_webapp.mvc.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.jboss.logging.Logger;

import fr.dauphine.secondMarket.sm_webapp.mvc.bean.UserBean;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, description = "authentification filter", urlPatterns = { "/SecurityFilter" }, servletNames = { "jboss-as-kitchensink" })
public class SecurityFilter implements Filter {
	
	private static final Logger logger=Logger.getLogger(SecurityFilter.class.getCanonicalName());
	
	public static final String ACCES_PUBLIC     = "/";
    public static final String ATT_SESSION_USER = "userBean";

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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

        /* Cast des objets request et response */
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( session.getAttribute( ATT_SESSION_USER ) == null ) {
            /* Redirection vers la page publique */
            response.sendRedirect( request.getContextPath() + ACCES_PUBLIC );
        } else {
        	UserBean userBean=session.getAttribute( ATT_SESSION_USER );
        	if(userBean.isConneted()){
        		/* Affichage de la page restreinte */
                chain.doFilter( request, response );
        	}else {
        		 response.sendRedirect( request.getContextPath() + ACCES_PUBLIC );
			}
            
        }
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("*****************init filter");
	}

}
