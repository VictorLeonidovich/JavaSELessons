package interfaces;

import java.io.IOException;

import exceptions.NotTrueFormatException;
import exceptions.OutOfRangeException;

public interface Initializable {
	public void initialize() throws IOException, OutOfRangeException, NotTrueFormatException;

}
