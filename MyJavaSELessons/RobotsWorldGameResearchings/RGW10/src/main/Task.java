package main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Task {
	private final long id;
	// may be null
	private final RobotTypeTarget robotExecutorType;
	// may be null
	private final Integer robotIdTarget;
	private final Mission mission;
	private Log LOG = LogFactory.getLog(Task.class);

	public Task(long id, RobotTypeTarget robotExecutorType, Integer robotTarget, Mission mission) {
		this.id = id;
		this.robotExecutorType = robotExecutorType;
		this.mission = mission;
		this.robotIdTarget = robotTarget;
		LOG.debug(toString() + " created!");
	}

	public long getId() {
		return id;
	}

	public RobotTypeTarget getRobotExecutorType() {
		return robotExecutorType;
	}

	public Integer getRobotIdTarget() {
		return robotIdTarget;
	}

	public Mission getMission() {
		return mission;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", robotExecutorType=" + robotExecutorType + ", robotIdTarget=" + robotIdTarget
				+ ", mission=" + mission + "]";
	}

	

}
