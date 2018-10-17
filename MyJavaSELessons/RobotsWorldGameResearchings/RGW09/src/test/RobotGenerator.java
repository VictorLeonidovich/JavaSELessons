package test;

import java.util.concurrent.TimeUnit;

import main.FacadeDispatcher;


public class RobotGenerator implements Runnable {
	private final String[] robotTypes;// = { "Builder", "Destroyer", "Killer",
										// "Defender" };
	private final FacadeDispatcher facadeDispatcher;

	public RobotGenerator(FacadeDispatcher facadeDispatcher) {
		this.facadeDispatcher = facadeDispatcher;
		this.robotTypes = facadeDispatcher.getRobotTypesStringArray();
	}
/*
	// TODO repeat
	private void fillRobotTypesStringArray(RobotTypeUtils[] robotType) {
		int index = 0;
		for (RobotTypeUtils temporaryRobotType : robotType) {
			robotTypes[index] = temporaryRobotType.toString().toLowerCase();
			index++;
		}
	}*/

	@Override
	public void run() {
		for (int i = 0; i < robotTypes.length * 2; i++) {
			facadeDispatcher.addOwnRobot(getRandomRobotType());
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// TODO repeat
	public synchronized String getRandomRobotType() {
		return robotTypes[getRandomIndexOfStringArray(robotTypes)];
	}

	// TODO repeat
	public synchronized int getRandomIndexOfStringArray(String[] stringArray) {
		return (int) (Math.random() * stringArray.length);
	}
}
