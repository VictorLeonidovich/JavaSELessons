package chain;

import exceptions.NoSmallerElementException;

public class SmallerChecking {
	private Integer objectToCheck;
	private Integer standardObject;
	
	public boolean isSmaller() throws NoSmallerElementException{
		if (objectToCheck < standardObject){
			return true;
		}else{
			throw new NoSmallerElementException();
		}
	}

}
