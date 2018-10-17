package main;

public class TaskFactory {
	private String[] parsedStringTask;
	private long id;
	private RobotType robotExecutorType;
	private String mission;

	public Task createTask(String stringTask) throws Exception {
		parseStringTask(stringTask);
		return finishTaskCreating(stringTask);
	}

	private Task finishTaskCreating(String stringTask) throws Exception {
		if (this.id > 0 || this.robotExecutorType != null || this.mission != null) {
			return new Task(this.id, this.robotExecutorType, this.mission);
		} else {
			throwException("Task can not be created because of wrong string task format: " + stringTask);
			return null;// TODO
		}

	}

	private void parseStringTask(String stringTask) throws Exception {

		parsedStringTask = stringTask.split(":");
		if (parsedStringTask.length != 3) {
			throwException("Task can not be created because of wrong string task format: count of ':' not equals 2.");
		}
		validateId(prepareString(parsedStringTask[0]));
		validateRobotExecutorType(prepareString(parsedStringTask[1]));
		validateMission(prepareString(parsedStringTask[2]));
	}

	private void throwException(String message) throws Exception {
		throw new Exception(message);
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
		return stringNumber.matches("[0-9]+");
	}

	private void validateRobotExecutorType(String temporaryRobotExecutorType) throws Exception {
		if (temporaryRobotExecutorType != null) {
			for (RobotType robotType : RobotType.values()) {
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
			for (RobotType robotType : RobotType.values()) {
				if (robotType.getMission().equals(temporaryMission)) {
					this.mission = temporaryMission;
					return;
				}
			}
		}
		throwException(
				"Task can not be created because of wrong mission format: do not exist mission of " + temporaryMission);
	}

	private String prepareString(String string) {
		return string.trim().toLowerCase();
	}

}
