package facades;

import classes.MessageFormation;
import classes.MessagePreparation;

public class PresentationBusinessTierFacade {
	private MessageFormation messageFormation = new MessageFormation();
	private MessagePreparation messagePreparation = new MessagePreparation();
	
	public void sendMessageAndGetResponse(String message){
		printMessage(message);
		preparation.setMessage(inputMessage());
	}
}
