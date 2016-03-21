/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.mvc.filter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * @author gnepa.rene.barou
 *
 */
public class ErrorHandleFilter implements Filter {
	private static final Logger logger=Logger.getLogger(ErrorHandleFilter.class.getCanonicalName());
	@Override
	public void destroy() {
		// ...
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//
	}

	@Override
	public void doFilter(ServletRequest request, 
               ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		logger.info("ErrorHandleFilter doFilter()");
		try {
			chain.doFilter(request, response);
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(),ex.getCause());
			request.setAttribute("errorMessage", ex);
			request.getRequestDispatcher("/WEB-INF/views/public/error.jsp")
                               .forward(request, response);
		}

	}



}
