package fr.dauphine.secondMarket.sm_webapp.exception;

public class SmDaoException extends SmException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2697933982743769191L;

	public SmDaoException() {
		super();
	}

	public SmDaoException(final String message) {
		super(message);
	}


	public SmDaoException(final String message, final Throwable cause) {
		super(message, cause);
	}


}
