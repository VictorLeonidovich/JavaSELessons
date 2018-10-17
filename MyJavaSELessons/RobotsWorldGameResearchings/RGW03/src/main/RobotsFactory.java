package main;

import java.util.Deque;

public class RobotsFactory {

	public Thread createAndStartRobot(long robotsCount, Deque<String> tasksStorage, Deque<String> logsStorage) {
		long id = robotsCount;
		Robot robot = new Robot(id, tasksStorage, logsStorage);
		Thread robotThread = new Thread(robot);
		robotThread.setDaemon(true);
		robotThread.start();
		return robotThread;
	}

}
