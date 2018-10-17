package main;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import main.logstorage.ILogStorage;
import main.robotmanagement.RobotCreation;
import main.robotmanagement.RobotsThreadsDistribution;
import main.robotmanagement.ThreadStarter;

public class ActivityTracker implements Runnable {
	// private GameController gameController;
	private final List<Thread> robotsStorage;
	//private final RobotsFactory robotsFactory;
	//private final ILogStorage logsStorage;
	private Log LOG = LogFactory.getLog(ActivityTracker.class);
	private final RobotCreation robotCreation;
	private final ThreadStarter threadStarter;
	private final RobotsThreadsDistribution robotsThreadsDistribution;
	/*
	 * public ActivityTracker(GameController gameController) {
	 * this.gameController = gameController; }
	 */

	public ActivityTracker(List<Thread> robotsStorage, /*RobotsFactory robotsFactory,*/ ILogStorage logsStorage,
			RobotCreation robotCreation, ThreadStarter threadStarter,
			RobotsThreadsDistribution robotsThreadsDistribution) {
		this.robotsStorage = robotsStorage;
		//this.robotsFactory = robotsFactory;
		//this.logsStorage = logsStorage;
		this.robotCreation = robotCreation;
		this.threadStarter = threadStarter;
		this.robotsThreadsDistribution = robotsThreadsDistribution;
	}

	private void checkRobotsActivity() {
		for (RobotTypeUtils robotExecutorType : RobotTypeUtils.values()) {
			if (hasNoRobot(robotExecutorType) || isHighRobotsActivity(robotExecutorType)) {
				needNewRobotWithType(robotExecutorType);
			}
		}
	}
//TODO can delete synchronized because robotCreation.createRobotByType(robotExecutorType) is synchronized
	public synchronized void needNewRobotWithType(RobotTypeUtils robotExecutorType) {
		robotCreation.createRobotByType(robotExecutorType);
		// addNewRobotToStorage(robotExecutorType);
	}

	/*
	 * private void addNewRobotToStorage(RobotTypeUtils robotExecutorType) {
	 * robotsStorage.add(robotsFactory.createAndStartRobot(robotExecutorType,
	 * logsStorage)); robotExecutorType.increaseRobotsAmount(); }
	 */

	private boolean isHighRobotsActivity(RobotTypeUtils robotExecutorType) {
		long tasksAmount = robotExecutorType.getTasksAmount();
		long robotsAmount = robotExecutorType.getRobotsAmount();
		boolean isHighRobotsActivity = robotExecutorType.getTasksAmount() > robotExecutorType.getRobotsAmount();
		LOG.debug("For RobotType=" + robotExecutorType + " isHighRobotsActivity=" + isHighRobotsActivity
				+ ", tasksAmount=" + tasksAmount + ", robotsAmount=" + robotsAmount);
		return isHighRobotsActivity;
	}

	private boolean hasNoRobot(RobotTypeUtils robotExecutorType) { // TODO
																	// hasRobot()?
		return robotExecutorType.hasNoRobot(robotExecutorType);
	}

	@Override
	public void run() {
		while (true) {
			checkRobotsActivity();
			checkRobotsIsAlive();
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void checkRobotsIsAlive() {
		startDiedRobot();

	}

	private void startDiedRobot() {
		for (Thread robotThread : robotsStorage) {
			if (!robotThread.isAlive()) {
				robotsThreadsDistribution.removeDiedRobot(robotThread);
				// robotsStorage.remove(robotThread);

				Robot robot = robotCreation.findRobotByStringId(robotThread.getName());
				
				threadStarter.startRobotThread(robot);
				//Thread temporaryRobotThread = robotsFactory.startRobot(robotThread.getName());
				//robotsStorage.add(temporaryRobotThread);
				LOG.debug(robotThread + " was alived over again.");
			} else {
				// LOG.debug(robotThread + " is alive.");
			}
		}
	}

}
