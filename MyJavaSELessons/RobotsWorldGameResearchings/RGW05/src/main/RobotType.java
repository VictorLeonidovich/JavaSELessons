package main;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public enum RobotType {
	BUILDER("build", 0L, 0L, new ConcurrentLinkedDeque<Task>()), DESTROYER("destroy", 0L, 0L,
			new ConcurrentLinkedDeque<Task>()), ALL("all", 0L, 0L, new ConcurrentLinkedDeque<Task>());
	private String mission;
	private long robotsAmount;
	private long tasksAmount;
	private volatile Deque<Task> tasksStorage;
	private Log LOG = LogFactory.getLog(RobotType.class);

	private RobotType(String mission, long robotsAmount, long tasksAmount, Deque<Task> tasksStorage) {
		this.mission = mission;
		this.tasksStorage = tasksStorage;
	}

	public String getMission() {
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

	/*private Deque<Task> getTasksStorage() {
		return tasksStorage;
	}*/

	public synchronized boolean hasNoRobot(RobotType robotExecutorType) {
		return getTasksAmount() == 0;
	}

	private long increaseTasksAmount() {
		++tasksAmount;
		LOG.debug("For RobotType=" + this + " TasksAmount was increased. Now tasksAmount=" + tasksAmount);
		return tasksAmount;
	}

	private void decreaseTasksAmount() {
		--tasksAmount;
		LOG.debug("For RobotType=" + this + " TasksAmount was decreased. Now tasksAmount=" + tasksAmount);
	}

	public long getTasksAmount() {
		return tasksAmount;
	}

	public long getRobotsAmount() {
		return robotsAmount;
	}
	public long increaseRobotsAmount() {
		++robotsAmount;
		LOG.debug("For RobotType=" + this + " RobotsAmount was increased. Now robotsAmount=" + robotsAmount);
		return robotsAmount;
	}
}
