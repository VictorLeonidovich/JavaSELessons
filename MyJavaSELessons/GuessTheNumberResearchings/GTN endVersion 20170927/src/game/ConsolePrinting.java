package game;

import interfaces.Printable;

public class ConsolePrinting implements Printable {

	@Override
	public void print(String text) {
		if (text == "" || text == null) {
			return;
		}
		System.out.println(text);
		
	}

}
