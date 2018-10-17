package main;

import java.util.Deque;
import java.util.List;

public class ActivityTracker {
	private Deque<String> tasksStorage;
	private Deque<String> logsStorage;
	private final List<Thread> robotsStorage;
	private long taskCount;
	private RobotsFactory robotsFactory;
	private long robotsCount;

	public ActivityTracker(Deque<String> tasksStorage, Deque<String> logsStorage, List<Thread> robotsStorage) {
		this.tasksStorage = tasksStorage;
		this.logsStorage = logsStorage;
		this.robotsStorage = robotsStorage;
		this.robotsFactory = new RobotsFactory();
		taskCount = 0L;
		robotsCount = 0L;
	}

	public void notifyAboutAppearedTask(String stringTask) {
		addTaskInTaskStorage(stringTask);
		if (hasNoRobot() || isHighRobotsActivity()) {
			addNewRobotToStorage();
		}
	}

	private void addNewRobotToStorage() {
		robotsStorage.add(robotsFactory.createAndStartRobot(increaseRobotsCount(), tasksStorage, logsStorage));
		;
	}

	private long increaseRobotsCount() {
		return ++robotsCount;		
	}

	private boolean isHighRobotsActivity() {
		return tasksStorage.size() > robotsStorage.size();
	}

	private boolean hasNoRobot() {
		return robotsStorage.isEmpty();
	}

	private void addTaskInTaskStorage(String stringTask) {
		tasksStorage.addFirst(stringTask);
		increaseTaskCount();		
	}

	private long increaseTaskCount() {
		return ++taskCount;		
	}

}
