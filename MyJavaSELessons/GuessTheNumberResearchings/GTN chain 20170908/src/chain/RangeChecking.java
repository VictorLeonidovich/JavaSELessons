package chain;

import exceptions.NotInitializationException;
import exceptions.OutOfRangeException;

public class RangeChecking {
	private Integer objectToControl;
	private Integer minLimitOfRange = 1;
	private Integer maxLimitOfRange = 9;
	
	
	public void checkRange() throws OutOfRangeException, NumberFormatException, NotInitializationException{
		//TODO not null
		objectToControl = new StringToIntegerConversion().convertStringToInteger();
		
		if (objectToControl < minLimitOfRange || objectToControl > maxLimitOfRange){
			throw new OutOfRangeException();
		}
	}

}
