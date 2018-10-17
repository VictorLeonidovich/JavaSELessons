package main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Task {
	private final long id;
	private final SimpleRobotType robotExecutorType;
	private final String mission;
	private Log LOG = LogFactory.getLog(Task.class);
	

	public Task(long id, SimpleRobotType robotExecutorType, String mission) {
		this.id = id;
		this.robotExecutorType = robotExecutorType;
		this.mission = mission;
		LOG.debug(toString() + " created!");
	}

	public long getId() {
		return id;
	}

	public SimpleRobotType getRobotExecutorType() {
		return robotExecutorType;
	}

	public String getMission() {
		return mission;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", robotExecutorType=" + robotExecutorType + ", mission=" + mission + "]";
	}

}
