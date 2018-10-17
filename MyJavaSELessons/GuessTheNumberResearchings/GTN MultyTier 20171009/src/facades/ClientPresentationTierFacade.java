package facades;

import classes.Console;
import classes.MessagePreparation;
import interfaces.Inputable;
import interfaces.Printable;

public class ClientPresentationTierFacade {
	private Printable printableObject = new Console();
	private Inputable inputableObject = new Console();
	private MessagePreparation preparation = new MessagePreparation();
	
	private void printMessage(String message){
		printableObject.print(message);
	}
	private String inputMessage(){
		return inputableObject.input();
	}
	public void sendMessageAndGetResponse(String message){
		printMessage(message);
		preparation.setMessage(inputMessage());
	}
	
	

}
