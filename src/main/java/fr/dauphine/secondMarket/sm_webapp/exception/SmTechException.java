package fr.dauphine.secondMarket.sm_webapp.exception;

public class SmTechException  extends SmException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3073230572952209006L;

	public SmTechException() {
		super();
	}

	public SmTechException(final String message) {
		super(message);
	}


	public SmTechException(final String message, final Throwable cause) {
		super(message, cause);
	}


}
