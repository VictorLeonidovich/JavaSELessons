package exceptions;

public class NotBiggerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageToPrint;
	public NotBiggerException(String formString,String messageToPrint) {
		super();
		this.messageToPrint = String.format(messageToPrint, formString);
	}
	public String getMessageToPrint() {
		return messageToPrint;
	}
}
