package main;

public class FacadeDispatcher implements IRobotsGameWorld {
	private GameController gameController;

	public FacadeDispatcher() {
		this.gameController = new GameController();
	}

	@Override
	public synchronized void addStringTask(String stringTask) {
		gameController.notifyActivityTrackerAboutAppearedTask(stringTask);
	}

	@Override
	public String getStringLog() {
		String log = gameController.pollLastLog();
		if (log == null) {
			log = "no message.";
		}
		return log;
	}

}
