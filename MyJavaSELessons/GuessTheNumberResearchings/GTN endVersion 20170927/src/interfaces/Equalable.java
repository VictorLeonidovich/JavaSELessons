package interfaces;

import exceptions.NotEqualsException;
import exceptions.NotInitializationException;

public interface Equalable {
	//TODO Integer need to refactoring
	public Integer getComparableObject();
	public boolean isEquals(Equalable equalableObject) throws NotEqualsException, NotInitializationException;

}
