package main;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import main.logstorage.ILogStorage;
import main.taskmanagement.TaskValidation;

public class GameController {
	private volatile List<Thread> robotsStorage = new CopyOnWriteArrayList<>();
	private final ActivityTracker activityTracker = new ActivityTracker(this);
	private Thread activityTrackerThread;
	private Log LOG = LogFactory.getLog(GameController.class);
	private final ILogStorage logsStorage;
	private final String gameBeginningLogMessage = "The Robots World Game is beginning!!!";
	private final String gameDescriptionLogMessage = "There is the Robots Game World. There are %d robots here: \r\n%s\r\n";
	private final RobotsFactory robotsFactory;
	//private final TaskValidation validator;
	
	public GameController(ILogStorage logsStorage, /*TaskValidation validator, */RobotsFactory robotsFactory) {
		this.logsStorage = logsStorage;
		//this.validator = validator;
		this.robotsFactory = robotsFactory;
		this.logsStorage.addStringLog(gameBeginningLogMessage);
		for (RobotTypeUtils robotExecutorType : RobotTypeUtils.values()) {
			addNewRobotToStorage(robotExecutorType);
		}
		startActivityTracker();
		this.logsStorage.addStringLog(String.format(gameDescriptionLogMessage, RobotsUtils.getAllRobotsAmount(),
				robotsFactory.getAllRobotsStringList()));
	}

	private void addNewRobotToStorage(RobotTypeUtils robotExecutorType) {
		robotsStorage.add(robotsFactory.createAndStartRobot(robotExecutorType, logsStorage));
		robotExecutorType.increaseRobotsAmount();
	}

	private void startActivityTracker() {
		activityTrackerThread = new Thread(activityTracker);
		activityTrackerThread.setDaemon(true);
		activityTrackerThread.start();
	}

	

	public void addLogFirst(String stringLog) {
		logsStorage.addStringLog(stringLog);
	}

	public void needNewRobotWithType(RobotTypeUtils robotExecutorType) {
		addNewRobotToStorage(robotExecutorType);
	}

	public void startDiedRobot() {
		for (Thread robotThread : robotsStorage) {
			if (!robotThread.isAlive()) {
				robotsStorage.remove(robotThread);
				Thread temporaryRobotThread = robotsFactory.startRobot(robotThread.getName());
				robotsStorage.add(temporaryRobotThread);
				LOG.debug(robotThread + " was alived over again.");
			} else {
				// LOG.debug(robotThread + " is alive.");
			}
		}
	}

}
