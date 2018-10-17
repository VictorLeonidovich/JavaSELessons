package chain;

import java.io.IOException;

import exceptions.NotInitializationException;

public class StringToIntegerConversion {
	private Integer integerResource;
	private StringExtraction stringExtractionObject;
	
	public Integer getNewIntegerResource() throws NumberFormatException, NotInitializationException, IOException {
		convertStringToInteger();
		return integerResource;
	}
	public void setIntegerResource(Integer integerResource) {
		this.integerResource = integerResource;
	}
	private void convertStringToInteger() throws NumberFormatException, NotInitializationException, IOException{
		if (stringExtractionObject == null) {
			stringExtractionObject = new StringExtraction();
		}
		setIntegerResource(Integer.parseInt(stringExtractionObject.getNewExtractedString()));
	}

}

