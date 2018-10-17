import classes.ResourcesManaging;

public class Start {

	public static void main(String[] args) {
		ResourcesManaging game = new ResourcesManaging();
		game.initializeResources();
		game.manageResources();
		game.closeResources();

	}

}
