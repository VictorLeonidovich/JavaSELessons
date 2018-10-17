package main.robotmanagement;

import main.Robot;

public class ThreadStarter {
	private final RobotsThreadsDistribution robotsThreadsDistribution;

	public ThreadStarter(RobotsThreadsDistribution robotsThreadsDistribution) {
		this.robotsThreadsDistribution = robotsThreadsDistribution;
	}

	public void startRobotThread(Runnable robot) {
		Thread robotThread = new Thread(robot);
		robotThread.setName(String.valueOf(((Robot) robot).getId()));
		robotThread.setDaemon(true);
		robotThread.start();
		robotsThreadsDistribution.distributeRobotsThread(robotThread);
	}
}
