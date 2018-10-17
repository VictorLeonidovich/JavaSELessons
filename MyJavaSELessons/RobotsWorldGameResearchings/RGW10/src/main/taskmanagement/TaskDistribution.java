package main.taskmanagement;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import main.Robot;

public class TaskDistribution {
	private final List<Robot> robots;
	private Log LOG = LogFactory.getLog(TaskDistribution.class);

	public TaskDistribution(List<Robot> robots) {
		this.robots = robots;
	}

	public void distributeTasks(Task[] tasks) {
		Task tempTask = null;
		for (Task task : tasks) {
			tempTask = task;
			LOG.debug("Try to add " + task);
			addTaskToTaskStorage(task);
			LOG.debug(task + " was successfully added.");
		}

	}
	private void addTaskToTaskStorage(Task task) {
		if (task.getRobotIdTarget() != null && task.getRobotExecutorType() == null) {
			addTaskToRobotWithId(task.getRobotIdTarget(), task);// TODO
			// TODO to refactor
		} else if (task.getRobotIdTarget() == null && task.getRobotExecutorType() != null) {
			task.getRobotExecutorType().getRobotType(task.getRobotExecutorType()).addTask(task);
		}
	}
	
	private void addTaskToRobotWithId(Integer id, Task task) {
		robots.get(id - 1).addTaskToPersonalTaskStorage(task);

	}

}
