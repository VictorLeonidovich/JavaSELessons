package main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Task {
	private final long id;
	// may be null
	private final RobotTypeTarget robotExecutorType;
	// may be null
	private final Long robotIdTarget;
	private final String mission;
	private Log LOG = LogFactory.getLog(Task.class);

	public Task(long id, RobotTypeTarget robotExecutorType, Long robotIdTarget, String mission) {
		this.id = id;
		this.robotExecutorType = robotExecutorType;
		this.mission = mission;
		this.robotIdTarget = robotIdTarget;
		LOG.debug(toString() + " created!");
	}

	public long getId() {
		return id;
	}

	public RobotTypeTarget getRobotExecutorType() {
		return robotExecutorType;
	}

	public Long getRobotIdTarget() {
		return robotIdTarget;
	}

	public String getMission() {
		return mission;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", robotExecutorType=" + robotExecutorType + ", robotIdTarget=" + robotIdTarget
				+ ", mission=" + mission + "]";
	}

	

}
