package main;

import java.util.Deque;

public class RobotsFactory {
	private long robotsCount;
	private RobotType robotType = RobotType.BUILDER;

	public RobotsFactory() {
		robotsCount = 0L;
	}

	public Thread createAndStartRobot(Deque<Task> tasksStorage, Deque<String> logsStorage) {
		Robot robot = createRobot(increaseRobotsCount(), robotType, tasksStorage, logsStorage);		
		return startRobot(robot);
	}

	private Thread startRobot(Robot robot) {
		Thread robotThread = new Thread(robot);
		robotThread.setDaemon(true);
		robotThread.start();
		return robotThread;
}

	private Robot createRobot(long id, RobotType robotType, Deque<Task> tasksStorage, Deque<String> logsStorage) {
		return new Robot(id, robotType, tasksStorage, logsStorage);
	}

	private long increaseRobotsCount() {
		return ++robotsCount;
	}

}
