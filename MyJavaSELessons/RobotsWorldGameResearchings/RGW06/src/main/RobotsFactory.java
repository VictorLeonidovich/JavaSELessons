package main;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RobotsFactory {
	private long robotsCount;
	private List<Robot> robots = new ArrayList<>();
	private Log LOG = LogFactory.getLog(RobotsFactory.class);
	
	public RobotsFactory() {
		robotsCount = 0L;
	}

	public Thread createAndStartRobot(RobotType robotExecutorType, Deque<String> logsStorage) {
		Robot robot = createRobot(increaseRobotsCount(), robotExecutorType, logsStorage);		
		robots.add((int)robot.getId() - 1, robot); //TODO bad casting
		LOG.debug(robot + " will be started over again.");
		return startRobot(robot);
	}

	private Thread startRobot(Robot robot) {
		Thread robotThread = new Thread(robot);
		robotThread.setName(String.valueOf(robot.getId()));
		robotThread.setDaemon(true);
		//robot.aliveRobot();
		robotThread.start();
		LOG.debug(robot + " was started over again.");
		return robotThread;
}

	private Robot createRobot(long id, RobotType robotType, Deque<String> logsStorage) {
		return new Robot(id, robotType, logsStorage);
	}

	private long increaseRobotsCount() {
		return ++robotsCount;
	}

	/*public void startRobot(Thread robotThread) {
		robotThread.setDaemon(true);
		robotThread.start();
		}*/

	public Thread startRobot(String robotId) {
		// TODO validation for catching exception
		long id = Long.parseLong(robotId);
		LOG.debug(robots.get((int)id - 1) + " will be alived over again.");
		return startRobot(robots.get((int)id - 1));//TODO Bad casting
	}

}
