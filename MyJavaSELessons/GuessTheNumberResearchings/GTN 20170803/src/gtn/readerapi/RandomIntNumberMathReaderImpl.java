package gtn.readerapi;

import gtn.readerapinew.ReadingType;

public class RandomIntNumberMathReaderImpl implements InterfObjectReader {
	
	
	private int generateIntNumber(){
		return numberToGuess = (int)(Math.random() * endNumberOfRange) + initialNumberOfRange;
	}

	@Override
	public ReadingType readRandomObject() {
		return generateIntNumber();
	}

}
