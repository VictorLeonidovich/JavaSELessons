package exceptions;

public class NotTrueFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageToPrint;
	public NotTrueFormatException(String messageToPrint) {
		super();
		this.messageToPrint = messageToPrint;
	}
	public String getMessageToPrint() {
		return messageToPrint;
	}

}
