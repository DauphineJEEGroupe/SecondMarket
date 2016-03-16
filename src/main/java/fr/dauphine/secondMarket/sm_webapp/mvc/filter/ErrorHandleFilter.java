/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.mvc.filter;

import org.jboss.logging.Logger;

/**
 * @author gb2c7dcn
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
		logger.info("*****************ErrorHandleFilter doFilter()");
		try {
			chain.doFilter(request, response);
		} catch (Exception ex) {
			request.setAttribute("errorMessage", ex);
			request.getRequestDispatcher("/WEB-INF/views/public/error.jsp")
                               .forward(request, response);
		}

	}

}
