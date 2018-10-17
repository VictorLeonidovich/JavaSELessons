package chain;

import exceptions.NotEqualException;
import exceptions.NotInitializationException;

public class EqualChecking {
	private Integer objectToEqualCheck;
	private Integer standardObject;
	
	public boolean isEqual() throws NotEqualException, NumberFormatException, NotInitializationException{
		objectToEqualCheck = new StringToIntegerConversion().convertStringToInteger();
		
		if (objectToEqualCheck.equals(standardObject)){
			return true;
		}else{
			throw new NotEqualException();
		}
	}

}
