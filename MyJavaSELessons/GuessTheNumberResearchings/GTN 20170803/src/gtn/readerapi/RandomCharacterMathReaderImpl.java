package gtn.readerapi;

import gtn.readerapinew.ReadingType;

public class RandomCharacterMathReaderImpl implements InterfObjectReader {
	
	
	
	private ReadingType convertIntToReadingType(int numberToConvert){
		
		return (char)numberToConvert;
	}

	@Override
	public ReadingType readRandomObject() {
		return convertCharToInt(generateCharacter());
	}
	

}
