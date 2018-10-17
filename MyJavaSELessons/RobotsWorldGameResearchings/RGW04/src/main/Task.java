package main;

public class Task {
	private final long id;
	private final RobotType robotExecutorType;
	private final String mission;

	public Task(long id, RobotType robotExecutorType, String mission) {
		this.id = id;
		this.robotExecutorType = robotExecutorType;
		this.mission = mission;
	}

	public long getId() {
		return id;
	}

	public RobotType getRobotExecutorType() {
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
