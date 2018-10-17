package main;

public class TaskFactory {
	// message задайте формат задачи правильно...
	private String[] parsedStringTask;
	private long id;
	private SimpleRobotType robotExecutorType;
	// private RobotType[] robotExecutorTypeArray;
	private String mission;
	private Task[] tasks;

	public Task[] createTask(String stringTask) throws Exception {
		clearFields();
		parseStringTask(stringTask);
		validateParsedStringTask();
		finishTaskCreating(stringTask);
		return tasks;
	}

	private void clearFields() {
		parsedStringTask = null;
		id = 0L;
		robotExecutorType = null;
		// robotExecutorTypeArray = null;
		mission = null;
		tasks = null;
	}

	private void parseStringTask(String stringTask) {

		parsedStringTask = stringTask.split(":");// TODO not null
	}

	private void validateParsedStringTask() throws Exception {
		validateParsedStringTaskLength();
		validateId(prepareString(parsedStringTask[0]));
		validateRobotExecutorType(prepareString(parsedStringTask[1]));
		validateMission(prepareString(parsedStringTask[2]));
	}

	private void validateParsedStringTaskLength() throws Exception {
		if (parsedStringTask.length != 3) {
			throwException("Task can not be created because of wrong string task format: count of ':' not equals 2.");
		}
	}

	private String prepareString(String string) {
		return string.trim().toLowerCase();
	}

	private void validateId(String temporaryId) throws Exception {
		if (temporaryId != null) {
			if (isNumber(temporaryId)) {
				this.id = Long.parseLong(temporaryId);
			} else {
				throwException("Task can not be created because of wrong id format: do not exist id of " + temporaryId);
			}
		}
	}

	private boolean isNumber(String stringNumber) {
		return stringNumber.matches("[0-9]+");// TODO maxLong
	}

	private void validateRobotExecutorType(String temporaryRobotExecutorType) throws Exception {
		if (temporaryRobotExecutorType != null) {
			for (SimpleRobotType robotType : SimpleRobotType.values()) {
				if (temporaryRobotExecutorType.equals(robotType.name().toLowerCase())) {
					this.robotExecutorType = robotType;
					return;
				}
			}
		}
		throwException("Task can not be created because of wrong RobotExecutorType format: do not exist type of "
				+ temporaryRobotExecutorType);
	}

	private void validateMission(String temporaryMission) throws Exception {
		if (temporaryMission != null) {
			for (Mission mission : Mission.values()) {
				if (mission.toString().toLowerCase().equals(temporaryMission)) {
					this.mission = temporaryMission;
					return;
				}
			}
		}
		throwException(
				"Task can not be created because of wrong mission format: do not exist mission of " + temporaryMission);
	}

	private void finishTaskCreating(String stringTask) throws Exception {
		if (this.id > 0 || this.robotExecutorType != null || this.mission != null) {
			if (SimpleRobotType.ALL.equals(robotExecutorType)) {
				int count = 0;
				tasks = new Task[RobotType.values().length];
				for (SimpleRobotType robotExecutorType : SimpleRobotType.values()) {
					if (robotExecutorType.equals(SimpleRobotType.ALL)) {
						continue;
					}
					tasks[count] = new Task(this.id, robotExecutorType, this.mission);
					count++;
				}
			} else {
				tasks = new Task[1];
				tasks[0] = new Task(this.id, this.robotExecutorType, this.mission);
			}
		} else {
			throwException("Task can not be created because of wrong string task format: " + stringTask);
			// return null;// TODO
		}
	}

	private void throwException(String message) throws Exception {
		throw new Exception(message);
	}

}
