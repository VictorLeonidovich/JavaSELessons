package chain;

import java.io.IOException;
import exceptions.NotInitializationException;

public class StringExtraction {
	private String extractedString;
	private ResourceToServer resourceToServer;
	
	public String getNewExtractedString() throws NotInitializationException, IOException {
		extractStringResource();
		return extractedString;
	}
	public void setExtractedString(String extractedString) {
		this.extractedString = extractedString;
	}
	private void extractStringResource() throws NotInitializationException, IOException{
		if(resourceToServer == null){
			resourceToServer = new ResourceToServer();
		}
		setExtractedString(resourceToServer.getNewStringResource());
		}
}
