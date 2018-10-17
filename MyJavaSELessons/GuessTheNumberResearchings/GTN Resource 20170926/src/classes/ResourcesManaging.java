package classes;
import interfaces.ResourcesManagable;

public class ResourcesManaging implements ResourcesManagable  {
	ClientResource clientResource;
	ServerResource serverResource;

	@Override
	public void initializeResources() {
		// TODO Auto-generated method stub
		clientResource = new ClientResource();
		serverResource = new ServerResource();
	}

	@Override
	public void manageResources() {
		// TODO Auto-generated method stub
		if (clientResource == null || serverResource == null) {
			initializeResources();
			manageResources();
		}
		if (clientResource.isEqual(serverResource)) {
			System.out.println("You are winner!");
		}else{
			
		}
		
	}

	@Override
	public void closeResources() {
		// TODO Auto-generated method stub
		
	}

}
