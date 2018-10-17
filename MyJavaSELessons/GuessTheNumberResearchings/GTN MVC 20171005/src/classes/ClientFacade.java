package classes;

public class ClientFacade {
	ClientConsole console;
	String serverMessage;
	
	public ClientFacade() {
		this(new ClientConsole());
	}
	
	public ClientFacade(ClientConsole console) {
		this.console = console;
	}

	public void setMessage(String message){
		this.serverMessage = message;
		//TODO it's no good
		this.console.print(message);
	}
	public String getMessage(){
		return console.createMessage();
	}

}
