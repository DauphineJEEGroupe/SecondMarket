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

/**
 * Servlet Filter implementation class ErrorHandlerFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.ERROR }
					, description = "redirect error page", urlPatterns = { "/ErrorHandlerFilter" })
public class ErrorHandlerFilter implements Filter {
	
	private static final Logger logger=Logger.getLogger(ErrorHandlerFilter.class.getCanonicalName());
    /**
     * Default constructor. 
     */
    public ErrorHandlerFilter() {
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
		try {
			chain.doFilter(request, response);
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage(),ex.getCause());
			request.setAttribute("errorMessage", ex);
			request.getRequestDispatcher("/WEB-INF/views/public/error.jsp")
                               .forward(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
