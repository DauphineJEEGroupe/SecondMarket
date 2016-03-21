/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.dauphine.secondMarket.sm_webapp.exception.SmException;
import fr.dauphine.secondMarket.sm_webapp.mvc.bean.UserBean;

/**
 * @author gnepa.rene.barou
 *
 */
public class UtilsSession {

	/**
	 * 
	 */
	public UtilsSession() {
		// TODO Auto-generated constructor stub
	}
	public static  UserBean getUserBean(HttpServletRequest request) throws SmException{
		HttpSession session = request.getSession();
	
		if (session.getAttribute(Constantes.ATT_SESSION_USER) == null) {
			throw new SmException("Utilisateur non connecté");
		} else {
			UserBean user=(UserBean) session
					.getAttribute(Constantes.ATT_SESSION_USER);
			session.setAttribute(Constantes.ATT_SESSION_USER, user);
			return user;
			}
	}
	
	public static  HttpSession getSession(HttpServletRequest request){
		return request.getSession();
		
	}
	
	public static  void setUserBeanSession(HttpServletRequest request){
		HttpSession session= request.getSession();
		
		session.invalidate();
		
	}
	public static  void logout(HttpServletRequest request){
		
	}
}
