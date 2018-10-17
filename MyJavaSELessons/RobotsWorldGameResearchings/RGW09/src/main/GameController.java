package main;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GameController {
	// private volatile Deque<Task> tasksStorage = new
	// ConcurrentLinkedDeque<>();
	private volatile Deque<String> logsStorage = new ConcurrentLinkedDeque<>();
	private volatile List<Thread> robotsStorage = new CopyOnWriteArrayList<>();
	private final ActivityTracker activityTracker = new ActivityTracker(this);
	private TaskFactory taskFactory = new TaskFactory();
	private RobotsFactory robotsFactory = new RobotsFactory();
	private Thread activityTrackerThread;
	private Log LOG = LogFactory.getLog(GameController.class);

	public GameController() {
		for (RobotTypeUtils robotExecutorType : RobotTypeUtils.values()) {
			addNewRobotToStorage(robotExecutorType);
		}
		startActivityTracker();
	}

	private void startActivityTracker() {
		activityTrackerThread = new Thread(activityTracker);
		activityTrackerThread.setDaemon(true);
		activityTrackerThread.start();
	}

	private void addNewRobotToStorage(RobotTypeUtils robotExecutorType) {
		robotsStorage.add(robotsFactory.createAndStartRobot(robotExecutorType, logsStorage));
		robotExecutorType.increaseRobotsAmount();
	}

	private Deque<String> getLogsStorage() {
		return logsStorage;
	}

	public void notifyActivityTrackerAboutAppearedTask(String stringTask) {
		Task tempTask = null;
		try {
			Task[] tasks = taskFactory.createTask(stringTask);
			for (Task task : tasks) {
				tempTask = task;
				LOG.debug("Try to add " + task);
				addTaskToTaskStorage(task);
				LOG.debug(task + " was successfully added.");
			}
		} catch (Exception e) {
			LOG.debug("Can not add the " + tempTask);
			logsStorage.addFirst("Can not add the Task [" + stringTask + "]. Cause: " + e.getMessage()
					+ System.lineSeparator() + Arrays.toString(e.getStackTrace()));
		}
	}

	private void addTaskToTaskStorage(Task task) {
		if (task.getRobotIdTarget() != null && task.getRobotExecutorType() == null) {
			robotsFactory.addTaskToRobotWithId(task.getRobotIdTarget(), task);// TODO
																		// to
																		// refactor
		} else if (task.getRobotIdTarget() == null && task.getRobotExecutorType() != null) {
			task.getRobotExecutorType().getRobotType(task.getRobotExecutorType()).addTask(task);
		}
	}

	public String pollLastLog() {
		return getLogsStorage().pollLast();
	}

	public void addLogFirst(String stringLog) {
		getLogsStorage().addFirst(stringLog);
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
