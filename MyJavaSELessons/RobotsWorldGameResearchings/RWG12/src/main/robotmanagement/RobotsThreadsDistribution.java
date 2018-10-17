package main.robotmanagement;

import java.util.List;

public class RobotsThreadsDistribution {
	private final List<Thread> robotsThreadsStorage;

	public RobotsThreadsDistribution(List<Thread> robotsThreadsStorage) {
		this.robotsThreadsStorage = robotsThreadsStorage;
	}

	public void distributeRobotsThread(Thread robotThread) {
		robotsThreadsStorage.add(robotThread);
		//TODO take into account: robot was added in RobotCreation.class
		//robotExecutorType.increaseRobotsAmount();

	}

	public void removeDiedRobot(Thread robotThread) {
		robotsThreadsStorage.remove(robotThread);		
	}

}
