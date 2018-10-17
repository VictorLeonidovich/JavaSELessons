package chain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReading {
	private String readedString;
	
	public String readFromConsole() throws IOException{
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			readedString = reader.readLine();
			}
		return readedString;
	}

}
