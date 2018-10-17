package exceptions;

import interfaces.Initializable;

public class NotInitializationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Initializable initializableObject;
	private String messageToPrint;
	public NotInitializationException(String messageToPrint, Initializable initializableObject) {
		super();
		this.initializableObject = initializableObject;
		this.messageToPrint = messageToPrint;
	}
	public Initializable getNonInitializedObject(){
		return initializableObject;
	}
	public String getMessageToPrint() {
		return messageToPrint;
	}
	

}
