package gtn.classes;

import gtn.interfaces.IIncrementable;

public class Attempt implements IIncrementable {
	private Integer currentAttempt = 1;
	private Integer attemptLimit = 3;

	@Override
	public void increment() {
		if(hasAttempt()){
		currentAttempt = currentAttempt + 1;
		}
	}

	private boolean hasAttempt() {
		
		return (currentAttempt < attemptLimit);
	}

}
