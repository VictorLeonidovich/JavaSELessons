package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import interfaces.Equalable;

public class ClientResource implements Equalable {
	private String textMessage;
	private Integer intNumber;

	@Override
	public boolean isEqual(ServerResource serverResource) {
		if (serverResource == null) {
			// TODO throw new NotInitExc
		}
		if (getIntNumber().equals(serverResource.getIntNumber())) {
			return true;
		}
		return false;
	}

	private Integer getIntNumber() {
		if (intNumber == null) {
			convertStringToInteger();
		}
		return intNumber;
	}

	private void convertStringToInteger() {
		// TODO Auto-generated method stub
		if (textMessage == null) {
			createTextMessage();
		}
		intNumber = Integer.parseInt(textMessage);
	}

	private void createTextMessage() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
			textMessage = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
