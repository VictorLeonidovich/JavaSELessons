package main;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GameController {
	private volatile Deque<Task> tasksStorage = new ConcurrentLinkedDeque<>();
	private volatile Deque<String> logsStorage = new ConcurrentLinkedDeque<>();
	private volatile List<Thread> robotsStorage = new CopyOnWriteArrayList<>();
	private final ActivityTracker activityTracker = new ActivityTracker(this);
	private TaskFactory taskFactory = new TaskFactory();
	private RobotsFactory robotsFactory = new RobotsFactory();
	private Thread activityTrackerThread;
	private Log LOG = LogFactory.getLog(GameController.class);

	public GameController() {
		for (RobotType robotExecutorType : RobotType.values()) {
			addNewRobotToStorage(robotExecutorType);
		}
		startActivityTracker();
	}

	private void startActivityTracker() {
		activityTrackerThread = new Thread(activityTracker);
		activityTrackerThread.setDaemon(true);
		activityTrackerThread.start();
	}

	private void addNewRobotToStorage(RobotType robotExecutorType) {
		robotsStorage.add(robotsFactory.createAndStartRobot(robotExecutorType, logsStorage));
		robotExecutorType.increaseRobotsAmount();
	}

	private Deque<Task> getTasksStorage() {
		return tasksStorage;
	}

	private Deque<String> getLogsStorage() {
		return logsStorage;
	}

	private List<Thread> getRobotsStorage() {
		return robotsStorage;
	}

	private ActivityTracker getActivityTracker() {
		return activityTracker;
	}

	public void notifyActivityTrackerAboutAppearedTask(String stringTask) {
		try {
			Task[] tasks = taskFactory.createTask(stringTask);
			for (Task task : tasks) {
				addTaskToTaskStorage(task);
			}
		} catch (Exception e) {
			logsStorage.addFirst("Can not add the Task [" + stringTask + "]. Cause: " + e.getMessage()
					+ System.lineSeparator() + Arrays.toString(e.getStackTrace()));
		}
	}

	// TODO [] - array
	private void addTaskToTaskStorage(Task task) {
		//String mission = task.getRobotExecutorType().getMission();
		/*if ("all".equals(task.getRobotExecutorType())) {
			LOG.debug("In 'addTaskToTaskStorage(Task task)' mission=" + mission);
			addTaskToAllTaskStorages(task);
		} else {*/
			task.getRobotExecutorType().getRobotType(task.getRobotExecutorType()).addTask(task);
		//}

	}

	private void addTaskToAllTaskStorages(Task task) {
		for (RobotType robotExecutorType : RobotType.values()) {
			robotExecutorType.addTask(task);
		}

	}

	public String pollLastLog() {
		return getLogsStorage().pollLast();
	}

	public void addLogFirst(String stringLog) {
		getLogsStorage().addFirst(stringLog);
	}

	public void needNewRobotWithType(RobotType robotExecutorType) {
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
