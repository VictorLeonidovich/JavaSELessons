package exceptions;

public class NotNextElementException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageToPrint;
	public NotNextElementException(String messageToPrint) {
		super();
		this.messageToPrint = messageToPrint;
	}
	public String getMessageToPrint() {
		return messageToPrint;
	}
}
