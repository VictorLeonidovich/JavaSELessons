
public class Attempt {
	private final int defaultAttemptNumber;
	private final int attemptMaxNumber;
	private int temporaryAttemptNumber;
	
	private void setTemporaryAttemptNumber(int attemptNumber) {
		this.temporaryAttemptNumber = attemptNumber;
	}
	
	public Attempt() {
		this(1, 3);
	}
	
	public Attempt(int defaultAttemptNumber, int atemptMaxNumber) {
		this.defaultAttemptNumber = defaultAttemptNumber;
		this.attemptMaxNumber = atemptMaxNumber;
		createTemporaryAttempt();
	}

	public void increaseAttempt() {
		if (hasNextAttempt()) {
			temporaryAttemptNumber = temporaryAttemptNumber + 1;
		}
	}

	public boolean hasNextAttempt() {
		if (temporaryAttemptNumber < attemptMaxNumber) {
			//add attemptIncrease() --- ?
			
			return true;
		} else {
			return false;
		}
	}

	public void createTemporaryAttempt() {
		setTemporaryAttemptNumber(defaultAttemptNumber);
	}
	
	public StringBuffer createMessageAboutNumberOfAttempt(StringBuffer stringBuffer){
		return stringBuffer.append(temporaryAttemptNumber);
	}

	public TextMessage getMessage() {
		if (temporaryAttemptNumber == defaultAttemptNumber) {
			increaseAttempt();
			return TextMessage.CREATE_WELCOME_AND_DESCRIPTION_MESSAGE;
		}
		
		return TextMessage.ATTEMPT_NUMBER_;
	}

}
