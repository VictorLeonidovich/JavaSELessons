package interfaces;

import exceptions.NotInitializationException;
import exceptions.NotNextElementException;

public interface HasNextCheckable {
	public boolean hasNextElement() throws NotInitializationException, NotNextElementException;

}
