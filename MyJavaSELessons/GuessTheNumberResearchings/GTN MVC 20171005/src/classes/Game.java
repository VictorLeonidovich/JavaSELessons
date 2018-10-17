package classes;

public class Game {
	ClientFacade client;
	ServerFacade server;
	public Game() {
		this(new ClientFacade(), new ServerFacade());
	}
	public Game(ClientFacade client, ServerFacade server) {
		super();
		this.client = client;
		this.server = server;
	}
	public void play() {
		// TODO Auto-generated method stub
		client.setMessage(server.getMessage());
		server.setMessage(client.getMessage());
		if(client.getMessage().toLowerCase() == "exit"){return;}else{play();}
	}
	
	
}
