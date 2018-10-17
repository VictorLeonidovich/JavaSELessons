package chain;

import exceptions.NoNextElementException;

public class NextElementChecking {
	private Integer elementToCheck;
	private Integer limit;
	
	public boolean hasNext() throws NoNextElementException{
		if(elementToCheck < limit){
			return true;
		}else{
			throw new NoNextElementException();
		}
	}

}
