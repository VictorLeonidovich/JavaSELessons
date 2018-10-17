package main.robotmanagement;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import main.Robot;
import main.RobotTypeUtils;
import main.logstorage.ILogStorage;

public class RobotCreation {
	private final ILogStorage logsStorage;
	private final List<Robot> robots;
	//TODO atomicinteger
	private int robotsCount;
	private final ThreadStarter threadStarter;
	private Log LOG = LogFactory.getLog(RobotCreation.class);
	
	public RobotCreation(List<Robot> robots, ILogStorage logsStorage, ThreadStarter threadStarter) {
		robotsCount = 0;
		this.logsStorage = logsStorage;
		this.robots = robots;
		this.threadStarter = threadStarter;
	}

	public synchronized void createRobotByType(RobotTypeUtils robotExecutorType) {
		Robot robot = createRobot(increaseRobotsCount(robotExecutorType), robotExecutorType, logsStorage);
		LOG.debug("(int) robot.getId() - 1 ==" + ((int) robot.getId() - 1));
		robots.add((int) robot.getId() - 1, robot); // TODO bad casting
		threadStarter.startRobotThread(robot);
	}
	private int increaseRobotsCount(RobotTypeUtils robotExecutorType) {
		//TODO take into account: robot is not thread yet
		robotExecutorType.increaseRobotsAmount();
		return ++robotsCount;
	}
	private Robot createRobot(long id, RobotTypeUtils robotType, ILogStorage logsStorage) {
		//TODO new LinkedList<>() move to Configuration.class
		return new Robot(id, robotType, logsStorage, new LinkedList<>());
	}

	public Robot findRobotByStringId(String stringRobotId) {
		int id = Integer.parseInt(stringRobotId);
		return robots.get(id - 1);
	}
}
