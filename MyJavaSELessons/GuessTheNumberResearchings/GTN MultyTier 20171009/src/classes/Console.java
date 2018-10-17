package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import interfaces.Inputable;
import interfaces.Printable;

public class Console implements Printable, Inputable {

	@Override
	public String input() {
		String readedMessage = null;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			readedMessage = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readedMessage;

	}

	@Override
	public void print(String message) {
		System.out.println(message);

	}

}
