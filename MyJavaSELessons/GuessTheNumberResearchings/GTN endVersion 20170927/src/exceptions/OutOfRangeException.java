package exceptions;

public class OutOfRangeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageToPrint;
	public OutOfRangeException(String messageToPrint) {
		super();
		this.messageToPrint = messageToPrint;
	}
	public String getMessageToPrint() {
		return messageToPrint;
	}
	

}
