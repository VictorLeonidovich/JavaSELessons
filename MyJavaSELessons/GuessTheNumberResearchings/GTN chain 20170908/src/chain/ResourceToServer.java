package chain;

import java.io.IOException;

public class ResourceToServer {
	private String stringResource;
	private ConsoleReading readingObject;

	public String getNewStringResource() throws IOException {
		createStringResource();
		return stringResource;
	}
	public void setStringResource(String stringResource) {
		this.stringResource = stringResource;
	}
	private void createStringResource() throws IOException {
		if (readingObject == null) {
			readingObject = new ConsoleReading();
		}
		setStringResource(readingObject.readFromConsole());
	}

}
