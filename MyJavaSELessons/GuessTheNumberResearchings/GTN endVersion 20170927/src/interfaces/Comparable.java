package interfaces;

import exceptions.NotBiggerException;
import exceptions.NotInitializationException;
import exceptions.NotSmallerException;

public interface Comparable {
	//TODO Integer need to refactoring
	public Integer getComparableObject();
	public void compareWith(Comparable comparableObject) throws NotSmallerException, NotBiggerException, NotInitializationException;

}
