package main;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ActivityTracker {
	private Deque<String> logsStorage;
	private final List<Thread> robotsStorage;
	private long taskCount;
	private RobotsFactory robotsFactory;
	private TaskFactory taskFactory = new TaskFactory();
	private Deque<Task> tasksStorage = new ConcurrentLinkedDeque<>();

	public ActivityTracker(Deque<Task> tasksStorage, Deque<String> logsStorage, List<Thread> robotsStorage) {
		this.tasksStorage = tasksStorage;
		this.logsStorage = logsStorage;
		this.robotsStorage = robotsStorage;
		this.robotsFactory = new RobotsFactory();
		taskCount = 0L;
	}

	public void notifyAboutAppearedTask(String stringTask) {
		try {
			addTaskToTaskStorage(taskFactory.createTask(stringTask));
		} catch (Exception e) {
			logsStorage.addFirst("Can not add the Task [" + stringTask + "]. Cause: " + e.getMessage()
					+ System.lineSeparator() + Arrays.toString(e.getStackTrace()));
		}
		if (hasNoRobot() || isHighRobotsActivity()) {
			addNewRobotToStorage();
		}
	}

	private void addTaskToTaskStorage(Task task) {
		tasksStorage.add(task);
		increaseTaskCount();
	}

	private void addNewRobotToStorage() {
		robotsStorage.add(robotsFactory.createAndStartRobot(tasksStorage, logsStorage));
	}

	private boolean isHighRobotsActivity() {
		return tasksStorage.size() > robotsStorage.size();
	}

	private boolean hasNoRobot() {
		return robotsStorage.isEmpty();
	}

	private long increaseTaskCount() {
		return ++taskCount;
	}

}
