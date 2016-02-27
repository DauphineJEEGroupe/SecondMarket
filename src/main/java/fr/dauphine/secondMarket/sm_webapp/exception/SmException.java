/**
 * 
 */
package fr.dauphine.secondMarket.sm_webapp.exception;

/**
 * @author gnepa.rene.barou
 *
 */
public class SmException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8534086306379066264L;

	/**
	 * 
	 */
	public SmException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public SmException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public SmException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public SmException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public SmException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
