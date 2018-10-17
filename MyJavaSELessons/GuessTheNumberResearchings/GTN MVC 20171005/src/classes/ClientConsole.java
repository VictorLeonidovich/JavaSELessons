package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientConsole {
	//TODO ??????
/*	BufferedReader bufferedReader;
	public ClientConsole() {
		//this(new BufferedReader(new InputStreamReader(System.in)));
	}

	public ClientConsole(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}*/

	public void print(String message) {
		System.out.println(message);
	}

	public String createMessage() {
		String temporaryString = null;
		try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
			temporaryString = bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			createMessage();
		}
		return temporaryString;
	}

}
