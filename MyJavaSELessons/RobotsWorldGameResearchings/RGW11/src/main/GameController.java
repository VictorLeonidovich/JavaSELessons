package main;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import main.logstorage.ILogStorage;
import main.robotmanagement.RobotTypeValidation;
import main.taskmanagement.StringFormatException;
import main.taskmanagement.TaskValidation;

public class GameController {
	private final ILogStorage logsStorage;
	private final TaskValidation taskValidation;
	//private final RobotsFactory robotsFactory;
	private final RobotTypeValidation robotTypeValidation;
	private volatile List<Thread> robotsThreadsStorage;
	private final ActivityTracker activityTracker;

	private Thread activityTrackerThread;
	private final String gameBeginningLogMessage = "The Robots World Game is beginning!!!";
	private final String gameDescriptionLogMessage = "There is the Robots Game World. There are %d robots here: \r\n%s\r\n";
	private Log LOG = LogFactory.getLog(GameController.class);

	public GameController(ILogStorage logsStorage, TaskValidation taskValidation, /*RobotsFactory robotsFactory,*/
			RobotTypeValidation robotTypeValidation, ActivityTracker activityTracker) {
		this.logsStorage = logsStorage;
		this.taskValidation = taskValidation;
		//this.robotsFactory = robotsFactory;
		this.robotTypeValidation = robotTypeValidation;
		this.activityTracker = activityTracker;
		// this.robotsThreadsStorage = new CopyOnWriteArrayList<>();
		/* this.logsStorage.addStringLog(gameBeginningLogMessage); */
		startActivityTracker();
		/*
		 * this.logsStorage.addStringLog(String.format(
		 * gameDescriptionLogMessage, RobotsUtils.getAllRobotsAmount(),
		 * robotsFactory.getAllRobotsStringList()));
		 */
	}

	private void startActivityTracker() {
		activityTrackerThread = new Thread(activityTracker);
		activityTrackerThread.setDaemon(true);
		activityTrackerThread.start();
	}

	public void addLogFirst(String stringLog) {
		logsStorage.addStringLog(stringLog);
	}

	public void validateStringTask(String stringTask) {
		try {
			taskValidation.validateStringTask(stringTask);
		} catch (StringFormatException e) {
			// TODO repeat
			logsStorage.addStringLog(e.getMessage() + " Please correct the mistake and try again.");
		}

	}

	public String getStringLog() {
		return logsStorage.getStringLog();
	}

	public List<String> getAllStringLogs() {
		return logsStorage.getAllStringLogs();
	}

	public void needNewRobotWithType(RobotTypeUtils robotExecutorType) {
		activityTracker.needNewRobotWithType(robotExecutorType);

	}

	public void validateRobotType(String stringRobotType) {
		try {
			robotTypeValidation.validateRobotType(stringRobotType);
		} catch (StringFormatException e) {
			// TODO repeat
			logsStorage.addStringLog(e.getMessage() + " Please correct the mistake and try again.");
		}

	}

}
