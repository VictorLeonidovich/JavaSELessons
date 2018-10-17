package dataprocessing.differentprocessing;

import java.io.IOException;

import dataprocessing.differentprocessing.interfaces.Parseable;

public class ParserFactory {
	private Parseable currentParser;

	public ParserFactory() {
		// TODO Auto-generated constructor stub
	}

	public Parseable getParser(String parserName) throws IOException {
		switch (parserName.toLowerCase()) {
		case "simple":
			// currentParser = new Simple
			System.out.println("Simple parser not supported now.");
			break;
		case "sax":
			// currentParser = new Simple
			System.out.println("SAX parser not supported now.");
			break;
		case "dom":
			// currentParser = new Simple
			System.out.println("DOM parser not supported now.");
			break;
		case "stax":
			// currentParser = new Simple
			System.out.println("StAX parser not supported now.");
			break;
		default:
			System.out.println("Entered word is mistaked. Try again.");
			//NewStart.main(new String[1]);
			break;
		}
		return currentParser;
	}

}
