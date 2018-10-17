package configurations;

import classes.Console;
import classes.MessageFormation;
import classes.MessagePreparation;
import classes.RandomNumber;
import facades.BusinessDataStorageTierFacade;
import facades.ClientPresentationTierFacade;
import facades.PresentationBusinessTierFacade;

public class Configuration {
	private ClientPresentationTierFacade clientPresentationTierFacade;
	private PresentationBusinessTierFacade presentationBusinessTierFacade;
	private BusinessDataStorageTierFacade businessDataStorageTierFacade;
	private Console console;
	private MessagePreparation messagePreparation;
	private MessageFormation messageFormation;
	private RandomNumber randomNumber;
	
	private void createDefaultObjects(){
		clientPresentationTierFacade = new ClientPresentationTierFacade();
		presentationBusinessTierFacade = new PresentationBusinessTierFacade();
		businessDataStorageTierFacade = new BusinessDataStorageTierFacade();
		
	}
	public void configureByDefault(){
		createDefaultObjects();
		
	}

}
