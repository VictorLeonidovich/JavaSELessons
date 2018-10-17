package main;

import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public enum RobotTypeUtils {
BUILDER(RobotTypeTarget.BUILDER, Mission.BUILD, 0L, 0L, new ConcurrentLinkedDeque<Task>(), new CopyOnWriteArrayList<Robot>()),
DESTROYER(RobotTypeTarget.DESTROYER, Mission.DESTROY, 0L, 0L, new ConcurrentLinkedDeque<Task>(), new CopyOnWriteArrayList<Robot>()),
KILLER(RobotTypeTarget.KILLER, Mission.KILL, 0L, 0L, new ConcurrentLinkedDeque<Task>(), new CopyOnWriteArrayList<Robot>()),
DEFENDER(RobotTypeTarget.DEFENDER, Mission.DEFEND, 0L, 0L, new ConcurrentLinkedDeque<Task>(), new CopyOnWriteArrayList<Robot>());
	
	private volatile RobotTypeTarget robotTypeTarget;
	private volatile Mission mission;
	private volatile long robotsAmount;
	private volatile long tasksAmount;
	private volatile Deque<Task> tasksStorage;
	private volatile List<Robot> robotsStorage;
	private Log LOG = LogFactory.getLog(RobotTypeUtils.class);

	private RobotTypeUtils(RobotTypeTarget robotTypeTarget, Mission mission, long robotsAmount, long tasksAmount,
			Deque<Task> tasksStorage, List<Robot> robotsStorage) {
		this.robotTypeTarget = robotTypeTarget;
		this.mission = mission;
		this.tasksStorage = tasksStorage;
		this.robotsStorage = robotsStorage;
	}
	
	public synchronized void addRobot(Robot robot){
		robotsStorage.add(robot);
	}
	
	//TODO
	/*public synchronized void addPersonalTask(Task task){
		
	}*/
	

	public synchronized Mission getMission() {
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

	public synchronized boolean hasNoRobot(RobotTypeUtils robotExecutorType) {
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

	public boolean isNativeMission(Mission mission) {
		return this.mission.equals(mission);
	}

	public RobotTypeTarget getRobotTypeTarget() {
		return robotTypeTarget;
	}


}
