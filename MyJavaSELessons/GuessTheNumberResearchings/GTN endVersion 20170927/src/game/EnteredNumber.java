package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exceptions.NotBiggerException;
import exceptions.NotEqualsException;
import exceptions.NotInitializationException;
import exceptions.NotSmallerException;
import exceptions.NotTrueFormatException;
import exceptions.OutOfRangeException;
import interfaces.Equalable;
import interfaces.Initializable;
import interfaces.Comparable;

public class EnteredNumber implements Equalable, Initializable, Comparable {
	private Integer enteredNumber;

	// TODO Integer need to refactoring
	public Integer getComparableObject() {
		return enteredNumber;
	}

	@Override
	public boolean isEquals(Equalable equalableObject) throws NotEqualsException, NotInitializationException {
		if (this.getComparableObject() == null) {
			throw new NotInitializationException(Messages.WELCOME_MESSAGE, this);
		}
		if (this.getComparableObject().equals(equalableObject.getComparableObject())) {
			return true;
		}
		throw new NotEqualsException();

	}

	@Override
	public void initialize() throws IOException, OutOfRangeException, NotTrueFormatException {
		Integer temporaryEnteredNumber;
		checkRange(temporaryEnteredNumber = convertStringToInteger(readStringFromConsole()));
		enteredNumber = temporaryEnteredNumber;
	}

	private void checkRange(Integer enteredNumber) throws OutOfRangeException {
		if (enteredNumber < 1 || enteredNumber > 9) {
			throw new OutOfRangeException(Messages.PLEASE_ENTER_NUMBER_IN_RANGE_MESSAGE);
		}

	}

	private String readStringFromConsole() throws IOException {
		System.out.println("----initialization----");
		String temporaryString;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		temporaryString = reader.readLine();

		return temporaryString;
	}

	private Integer convertStringToInteger(String anyString) throws NotTrueFormatException {
		Integer temporaryInteger;
		try {
			temporaryInteger = Integer.parseInt(anyString);
		} catch (NumberFormatException e) {
			throw new NotTrueFormatException(Messages.PLEASE_ENTER_NUMBER_IN_RANGE_MESSAGE);
		}
		return temporaryInteger;

	}

	@Override
	public void compareWith(Comparable comparableObject)
			throws NotBiggerException, NotInitializationException, NotSmallerException {
		if (this.getComparableObject() == null) {
			throw new NotInitializationException(Messages.WELCOME_MESSAGE, this);
		}
		if (comparableObject.getComparableObject() == null) {
			throw new NotInitializationException(Messages.NO_MESSAGE, (Initializable) comparableObject);
		}
		if (this.getComparableObject() < (comparableObject.getComparableObject())) {
			throw new NotBiggerException(Messages.SMALLER_MESSAGE, Messages.NUMBER_IS_SMALLER_OR_LAGER_MESSAGE);
		} else if (this.getComparableObject() > (comparableObject.getComparableObject())) {
			throw new NotSmallerException(Messages.LAGER_MESSAGE, Messages.NUMBER_IS_SMALLER_OR_LAGER_MESSAGE);
		}

	}

}
