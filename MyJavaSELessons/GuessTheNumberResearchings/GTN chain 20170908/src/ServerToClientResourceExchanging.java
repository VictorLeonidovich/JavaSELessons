import chain.ResourceToClient;
import chain.ResourceToServer;

public class ServerToClientResourceExchanging {
	private ResourceToClientFormation resourceToClientFormationObject;
	private ResourceToServerFormation resourceToServerFormationObject;
	private ResourceToClient resourceToClient;
	private ResourceToServer resourceToServer;
	

	public void exchangeResource() {
		resourceToClientFormationObject.formResourceToClient(resourceToClient);
		resourceToServerFormationObject.formResourceToServer(resourceToServer);
		
		// TODO if ... exit from recursion
		exchangeResource();
	}

}
