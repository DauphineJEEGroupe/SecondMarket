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
		super();
	}

	/**
	 * @param arg0
	 */
	public SmException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public SmException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public SmException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}


}
