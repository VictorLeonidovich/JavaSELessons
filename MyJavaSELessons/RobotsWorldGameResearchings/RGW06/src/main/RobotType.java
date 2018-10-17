package main;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public enum RobotType {
BUILDER("build", 0L, 0L, new ConcurrentLinkedDeque<Task>()),
DESTROYER("destroy", 0L, 0L, new ConcurrentLinkedDeque<Task>()),
KILLER("kill", 0L, 0L, new ConcurrentLinkedDeque<Task>()),
DEFENDER("defend", 0L, 0L, new ConcurrentLinkedDeque<Task>())/*,
ALL("killyourself", 0L, 0L, new ConcurrentLinkedDeque<Task>())*/;
	private volatile String mission;
	private volatile long robotsAmount;
	private volatile long tasksAmount;
	private volatile Deque<Task> tasksStorage;
	private Log LOG = LogFactory.getLog(RobotType.class);

	private RobotType(String mission, long robotsAmount, long tasksAmount, Deque<Task> tasksStorage) {
		this.mission = mission;
		this.tasksStorage = tasksStorage;
	}

	public synchronized String getMission() {
		return mission;
	}

	public synchronized Task pollTask() {
		Task task = tasksStorage.pollLast();
		if (task != null) {
			decreaseTasksAmount();
			return task;
		}
		return null;
	}

	public synchronized void addTask(Task task) {
		tasksStorage.addFirst(task);
		increaseTasksAmount();
	}

	public synchronized int getSize() {
		return (int) getTasksAmount();
	}

	/*
	 * private Deque<Task> getTasksStorage() { return tasksStorage; }
	 */

	public synchronized boolean hasNoRobot(RobotType robotExecutorType) {
		return getRobotsAmount() == 0;
	}

	private synchronized long increaseTasksAmount() {
		++tasksAmount;
		LOG.debug("For RobotType=" + this + " TasksAmount was increased. Now tasksAmount=" + tasksAmount);
		return tasksAmount;
	}

	private synchronized void decreaseTasksAmount() {
		--tasksAmount;
		LOG.debug("For RobotType=" + this + " TasksAmount was decreased. Now tasksAmount=" + tasksAmount);
	}

	public synchronized long getTasksAmount() {
		return tasksAmount;
	}

	public synchronized long getRobotsAmount() {
		return robotsAmount;
	}

	public synchronized long increaseRobotsAmount() {
		++robotsAmount;
		LOG.debug("For RobotType=" + this + " RobotsAmount was increased. Now robotsAmount=" + robotsAmount);
		return robotsAmount;
	}

	public boolean isNativeMission(String mission) {
		return this.mission.equals(mission);
	}
}
