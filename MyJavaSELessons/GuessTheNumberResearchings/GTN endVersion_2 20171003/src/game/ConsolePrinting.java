package game;

import interfaces.Printable;

public class ConsolePrinting implements Printable {

	@Override
	public void print(String message) {
		System.out.println(message);
		
	}

}
