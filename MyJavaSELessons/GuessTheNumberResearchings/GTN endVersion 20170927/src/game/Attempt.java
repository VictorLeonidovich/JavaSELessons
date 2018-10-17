package game;

import java.io.IOException;

import exceptions.NotInitializationException;
import exceptions.NotNextElementException;
import exceptions.OutOfRangeException;
import interfaces.HasNextCheckable;
import interfaces.Incrementable;
import interfaces.Initializable;

public class Attempt implements HasNextCheckable, Initializable, Incrementable {
	private Integer attempt;
	private Integer upperLimit;

	@Override
	public boolean hasNextElement() throws NotInitializationException, NotNextElementException {
		if (attempt == null) {
			throw new NotInitializationException(Messages.YOU_HAVE_SOME_ATTEMPTS_MESSAGE, this);
		}
		if (upperLimit == null) {
			throw new NotInitializationException(Messages.NO_MESSAGE, this);
		}
		if (attempt < upperLimit) {
			return true;
		}
		throw new NotNextElementException(Messages.YOU_DIDNT_HAVE_ANY_ATTEMPT_YOU_LOST_MESSAGE);
	}

	@Override
	public void initialize() throws NumberFormatException, IOException, OutOfRangeException {
		attempt = 1;
		upperLimit = 3;
	}
	@Override
	public void increment() {
		//TODO to Future hasNextElement();
		attempt = attempt + 1;
	}
	public String getMessageAboutAttempts(){
		
		return "" + (String.format(Messages.ATTEMPT_NUMBER_MESSAGE, attempt) + String.format(Messages.ATTEMPT_LEFT_MESSAGE, (upperLimit - attempt)));
	}

	

	
	

}
