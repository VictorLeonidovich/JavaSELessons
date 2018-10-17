package main;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameController {
	private volatile Deque<Task> tasksStorage = new ConcurrentLinkedDeque<>();
	private volatile Deque<String> logsStorage = new ConcurrentLinkedDeque<>();
	private volatile List<Thread> robotsStorage = new CopyOnWriteArrayList<>();
	private final ActivityTracker activityTracker = new ActivityTracker(this);
	private TaskFactory taskFactory = new TaskFactory();
	private RobotsFactory robotsFactory = new RobotsFactory();

	public GameController() {
		for (RobotType robotExecutorType : RobotType.values()) {
			addNewRobotToStorage(robotExecutorType);
		}
	}
	private void addNewRobotToStorage(RobotType robotExecutorType) {
		robotsStorage.add(robotsFactory.createAndStartRobot(robotExecutorType, /*tasksStorage, */logsStorage));
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
			addTaskToTaskStorage(taskFactory.createTask(stringTask));
		} catch (Exception e) {
			logsStorage.addFirst("Can not add the Task [" + stringTask + "]. Cause: " + e.getMessage()
					+ System.lineSeparator() + Arrays.toString(e.getStackTrace()));
		}

		getActivityTracker().notifyAboutAppearedTask(stringTask);
	}

	private void addTaskToTaskStorage(Task task) {
		task.getRobotExecutorType().addTask(task);
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

}
