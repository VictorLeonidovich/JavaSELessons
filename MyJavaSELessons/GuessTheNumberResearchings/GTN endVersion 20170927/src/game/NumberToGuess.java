package game;

import exceptions.NotBiggerException;
import exceptions.NotEqualsException;
import exceptions.NotInitializationException;
import exceptions.NotSmallerException;
import interfaces.Equalable;
import interfaces.Initializable;
import interfaces.Comparable;

public class NumberToGuess implements Equalable, Initializable, Comparable {
	private Integer numberToGuess;
	//TODO Integer need to refactoring
		public Integer getComparableObject(){
			return numberToGuess;
		}

	@Override
	public boolean isEquals(Equalable equalableObject) throws NotEqualsException, NotInitializationException {
		if (this.getComparableObject() == null) {
			throw new NotInitializationException(Messages.NO_MESSAGE, this);
		}
		if(this.getComparableObject().equals(equalableObject.getComparableObject())){
		return true;
		}
		throw new NotEqualsException();
	}

	@Override
	public void initialize() {
		numberToGuess = (int)(Math.random() * 9) + 1;
		
	}
	
	@Override
	public void compareWith(Comparable comparableObject) throws NotInitializationException, NotBiggerException, NotSmallerException {
		if (this.getComparableObject() == null) {
			throw new NotInitializationException(Messages.WELCOME_MESSAGE, this);
		}
		if (comparableObject.getComparableObject() == null) {
			throw new NotInitializationException(Messages.NO_MESSAGE, (Initializable)comparableObject);
		}
		if (this.getComparableObject() < (comparableObject.getComparableObject())) {
			throw new NotBiggerException(Messages.SMALLER_MESSAGE, Messages.NUMBER_IS_SMALLER_OR_LAGER_MESSAGE);
		} else if (this.getComparableObject() > (comparableObject.getComparableObject())) {
			throw new NotSmallerException(Messages.LAGER_MESSAGE, Messages.NUMBER_IS_SMALLER_OR_LAGER_MESSAGE);
		}
	}
	

}
