package main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TaskFactory {
	// message задайте формат задачи правильно...
	// private String[] parsedStringTask;
	/*
	 * private long id; private RobotTypeTarget robotExecutorType; private Long
	 * robotIdTarget; private Mission mission;
	 */
	// private Task[] tasks;
	private Log LOG = LogFactory.getLog(TaskFactory.class);
	
	public Task[] createTask(Object[] validatedTaskAttributes) {
		//LOG.debug("validatedTaskAttributes=" + validatedTaskAttributes);
		Task[] tasks = null;
		Integer id;
		//LOG.debug("validatedTaskAttributes[0]=" + validatedTaskAttributes[0]);
		if (validatedTaskAttributes[0] instanceof Integer) {
			id = (Integer) validatedTaskAttributes[0];
		} else {
			throw new UnsupportedOperationException("createTask");
		}
		Mission mission;
		if (validatedTaskAttributes[2] instanceof Mission) {
			mission = (Mission) validatedTaskAttributes[2];
		} else {
			throw new UnsupportedOperationException("createTask");
		}
		Object robotTarget = validatedTaskAttributes[1];
		if (id > 0 || mission != null) {
			if (robotTarget instanceof Integer) {
				tasks = new Task[1];
				tasks[0] = new Task(id, null, (Integer) robotTarget, mission);
				return tasks;
			}
			if (robotTarget instanceof RobotTypeTarget) {
				if (RobotTypeTarget.ALL.equals((RobotTypeTarget) robotTarget)) {
					int count = 0;
					tasks = new Task[RobotTypeUtils.values().length];
					for (RobotTypeTarget robotExecutorType : RobotTypeTarget.values()) {
						if (robotExecutorType.equals(RobotTypeTarget.ALL)) {
							continue;
						}
						tasks[count] = new Task(id, robotExecutorType, null, mission);
						count++;
					}
					return tasks;
				} else {
					tasks = new Task[1];
					tasks[0] = new Task(id, (RobotTypeTarget) robotTarget, null, mission);
					return tasks;
				}
			}
		}
		throw new UnsupportedOperationException("createTask"); //TODO delete Exception
	}
	/*
	 * private void finishTaskCreating(String stringTask) throws Exception {//
	 * TODO
	 * 
	 * if (this.id > 0 || this.robotExecutorType != null || this.mission !=
	 * null) { if (robotIdTarget != null && robotExecutorType == null) { tasks =
	 * new Task[1]; tasks[0] = new Task(this.id, null, this.robotIdTarget,
	 * this.mission); return; } else if (robotIdTarget == null &&
	 * robotExecutorType != null) { if
	 * (RobotTypeTarget.ALL.equals(robotExecutorType)) { int count = 0; tasks =
	 * new Task[RobotTypeUtils.values().length]; for (RobotTypeTarget
	 * robotExecutorType : RobotTypeTarget.values()) { if
	 * (robotExecutorType.equals(RobotTypeTarget.ALL)) { continue; }
	 * tasks[count] = new Task(this.id, robotExecutorType, null, this.mission);
	 * count++; } return; } else { tasks = new Task[1]; tasks[0] = new
	 * Task(this.id, this.robotExecutorType, null, this.mission); return; } }
	 * 
	 * } throwException(
	 * "Task can not be created because of wrong string task format: " +
	 * stringTask);
	 * 
	 * }
	 */

	/*
	 * private void clearFields() { parsedStringTask = null; id = 0L;
	 * robotExecutorType = null; robotIdTarget = null; mission = null; tasks =
	 * null; }
	 */

	/*
	 * private void parseStringTask(String stringTask) { parsedStringTask =
	 * stringTask.split(":");// TODO not null }
	 */

	/*
	 * private void validateParsedStringTask() throws Exception {
	 * validateParsedStringTaskLength();
	 * validateId(prepareString(parsedStringTask[0]));
	 * validateRobotExecutorType(prepareString(parsedStringTask[1]));
	 * validateMission(prepareString(parsedStringTask[2])); }
	 * 
	 * private void validateParsedStringTaskLength() throws Exception { if
	 * (parsedStringTask.length != 3) { throwException(
	 * "Task can not be created because of wrong string task format: count of ':' not equals 2."
	 * ); } }
	 */

	/*
	 * private String prepareString(String string) { return
	 * string.trim().toLowerCase(); }
	 * 
	 * private void validateId(String temporaryId) throws Exception { if
	 * (temporaryId != null) { if (isNumber(temporaryId)) { this.id =
	 * Long.parseLong(temporaryId); } else { throwException(
	 * "Task can not be created because of wrong id format: do not exist id of "
	 * + temporaryId); } } }
	 * 
	 * private boolean isNumber(String stringNumber) { return
	 * stringNumber.matches("[0-9]+");// TODO maxLong }
	 */

	/*
	 * private void validateRobotExecutorType(String temporaryRobotExecutorType)
	 * throws Exception { if (temporaryRobotExecutorType != null) { if
	 * (isNumber(temporaryRobotExecutorType)) { robotIdTarget =
	 * Long.parseLong(temporaryRobotExecutorType); return; } else { for
	 * (RobotTypeTarget robotType : RobotTypeTarget.values()) { if
	 * (temporaryRobotExecutorType.equals(robotType.name().toLowerCase())) {
	 * this.robotExecutorType = robotType; return; } } }
	 * 
	 * } throwException(
	 * "Task can not be created because of wrong RobotExecutorType format: do not exist type of "
	 * + temporaryRobotExecutorType); }
	 */

	/*
	 * private void validateMission(String temporaryMission) throws Exception {
	 * if (temporaryMission != null) { for (Mission mission : Mission.values())
	 * { if (mission.toString().toLowerCase().equals(temporaryMission)) {
	 * this.mission = mission; return; } } } throwException(
	 * "Task can not be created because of wrong mission format: do not exist mission of "
	 * + temporaryMission); }
	 */

	/*
	 * private void throwException(String message) throws Exception { throw new
	 * Exception(message); }
	 */

}
