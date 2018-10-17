package main;

public class RobotsUtils {

	public static synchronized long getAllRobotsAmount() { //synchronization object?
		long robotsAmount = 0;
		for (RobotTypeUtils robotType : RobotTypeUtils.values()) {
			robotsAmount = robotsAmount + robotType.getRobotsAmount();
		}
		return robotsAmount;
	}

	public static synchronized String getAllRobotsStringList() { //synchronization object?
		String robotsStringList = "";
		for (RobotTypeUtils robotType : RobotTypeUtils.values()) {
			robotsStringList = robotsStringList + robotType.getRobotsStorageStringList() + System.lineSeparator();  //TODO append
		}
		return robotsStringList;
	}

}
