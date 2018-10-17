package main.taskstorage;

import java.util.ArrayList;
import java.util.List;

import main.RealTask;
import main.RobotTypeTarget;

public class TaskValidation {
	/*
	 * private String stringTask; private Object[] validatedTaskAttributes;
	 * private final TaskCreation taskCreation;
	 */

	public String validateNotNull(String stringMission) throws StringFormatException {
		if (stringMission == null) {
			throw new StringFormatException(
					"Mission [" + stringMission + "] can not be taken into execution. Wrong string mission format.");

		}
		return stringMission;
	}

	public String[] parseStringMission(String notNullStringMission) {
		return notNullStringMission.split(":");
	}

	public boolean validateMissionAttributesAmount(String[] parsedStringMissionAttributes, String stringMission)
			throws StringFormatException {
		if (parsedStringMissionAttributes != null) {
			// TODO 3 add to constant
			if (parsedStringMissionAttributes.length != 3) {
				throw new StringFormatException("Mission [" + stringMission
						+ "] can not be taken into execution. Wrong string mission format. Amount of ':' not equals 2.");
			}
			return true;
		}
		throw new NullPointerException(
				"in method: public boolean validateMissionAttributesAmount(String[] parsedStringMissionAttributes)");
	}

	public String[] prepareStringMissionAttributes(String[] parsedStringMissionAttributes) {
		for (int i = 0; i < parsedStringMissionAttributes.length; i++) {
			parsedStringMissionAttributes[i] = parsedStringMissionAttributes[i].trim().toLowerCase();
		}
		return parsedStringMissionAttributes;
	}

	// TODO this is plug for later developments
	public int[] validateId(String missionId, String stringMission) throws StringFormatException {
		if (missionId != null) {
			int[] validatedId = new int[1];
			if (isNumber(missionId)) {
				validatedId[0] = Integer.parseInt(missionId);
			} else {
				throw new StringFormatException("Mission [" + stringMission
						+ "] can not be taken into execution. Wrong id format. Id is not number: [" + missionId + "].");
			}
			return validatedId;
		}
		throw new NullPointerException("in method: public int[] validateId(String missionId)");
	}

	// TODO isIntNumber
	private boolean isNumber(String stringNumber) {
		return stringNumber.matches("[0-9]+");// TODO is maxInt then throw
												// NumberFormatException
	}

	public List<Integer> getRobotIdsTargets(String targets) {
		if (targets != null) {
			// TODO class StringSplitting by ";" and ","
			String[] targetsArray = targets.split(",");
			List<Integer> targetIds = new ArrayList<>();
			for (String target : targetsArray) {
				if (isNumber(target)) {
					targetIds.add(Integer.parseInt(target));
				}
			}
			return targetIds;
		}
		throw new NullPointerException("in method: public int[] getRobotIdsTargets(String targets)");
	}

	// TODO repeated operations
	public List<RobotTypeTarget> getRobotTypesTargets(String targets, String stringMission) {
		if (targets != null) {
			// TODO may be
			// boolean wrongTargetFormatFlag = true;
			// TODO class StringSplitting by ";" and ","
			String[] targetsArray = targets.split(",");
			List<RobotTypeTarget> robotTypeTargets = new ArrayList<>();
			for (String target : targetsArray) {
				if (!isNumber(target)) {
					for (RobotTypeTarget robotTypeTarget : RobotTypeTarget.values()) {
						if (target.equals(robotTypeTarget.name().toLowerCase())) {
							robotTypeTargets.add(robotTypeTarget);
							// wrongTargetFormatFlag = false;
							break;
						}
					}
					/*
					 * if (wrongTargetFormatFlag ) { throw new
					 * StringFormatException("Mission [" + stringMission +
					 * "] can not be taken into execution. Wrong RobotTypesTarget format: ["
					 * + target + "]."); }
					 */
				}
			}
			return robotTypeTargets;
		}
		throw new NullPointerException(
				"in method: public int[] getRobotIdsTargets(String targets, String stringMission)");
	}

	public List<RealTask> validateTask(String stringTasks, String stringMission) throws StringFormatException {
		if (stringTasks != null) {
			// TODO class StringSplitting by ";" and ","
			String[] tasksArray = stringTasks.split(",");
			List<RealTask> tasks = new ArrayList<>();
			for (String stringTask : tasksArray) {
				for (RealTask task : RealTask.values()) {
					if (task.toString().toLowerCase().equals(stringTask)) {
						tasks.add(task);
						break;
					}
				}
				// TODO see getRobotTypesTargets(String targets, String
				// stringMission)
				/*
				 * throw new StringFormatException("Mission [" + stringMission +
				 * "] can not be taken into execution. Wrong mission format. Do not exist tasks: ["
				 * + stringTasks + "].");
				 */
			}
			return tasks;
		}
		throw new NullPointerException(
				"in method: public List<RealTask> validateTask(String stringTasks, String stringMission)");
	}
	// TODO delete this method
	/*
	 * public TaskCreation getTaskFactory() { return taskCreation; }
	 */

	/*
	 * public TaskValidation(TaskCreation taskCreation) { this.taskCreation =
	 * taskCreation; }
	 */

	/*
	 * public Object[] void validateStringMission(String stringMission) throws
	 * StringFormatException { this.stringTask = stringTask; // TODO object
	 * TaskParser return String[] String[] taskAttributes = parseStringTask();
	 * validateTaskAttributesAmount(taskAttributes); taskAttributes =
	 * prepareTaskAttributes(taskAttributes);
	 * validateTaskAttributes(taskAttributes);
	 * taskCreation.createTask(validatedTaskAttributes); // return
	 * validatedTaskAttributes; }
	 */
	/*
	 * private String[] parseStringTask() throws StringFormatException { if
	 * (stringTask != null) { return stringTask.split(":"); } throw new
	 * StringFormatException( "Task [" + stringTask +
	 * "] can not be taken into execution. Wrong string task format."); }
	 */

	/*
	 * private void validateTaskAttributesAmount(String[] taskAttributes) throws
	 * StringFormatException { if (taskAttributes != null) { if
	 * (taskAttributes.length != 3) { throw new StringFormatException("Task [" +
	 * stringTask +
	 * "] can not be taken into execution. Wrong string task format. Amount of ':' not equals 2."
	 * ); } validatedTaskAttributes = new Object[taskAttributes.length]; } }
	 */
	/*
	 * private String[] prepareTaskAttributes(String[] taskAttributes) { for
	 * (int i = 0; i < taskAttributes.length; i++) { taskAttributes[i] =
	 * taskAttributes[i].trim().toLowerCase(); } return taskAttributes; }
	 */

	/*
	 * private void validateTaskAttributes(String[] taskAttributes) throws
	 * StringFormatException { validateId(taskAttributes[0]);
	 * validateRobotExecutorType(taskAttributes[1]);
	 * validateMission(taskAttributes[2]); }
	 */

	/*
	 * private void validateRobotExecutorType(String temporaryRobotExecutorType)
	 * throws StringFormatException { if (temporaryRobotExecutorType != null) {
	 * if (isNumber(temporaryRobotExecutorType)) { validatedTaskAttributes[1] =
	 * Integer.parseInt(temporaryRobotExecutorType); return; } else { for
	 * (RobotTypeTarget robotType : RobotTypeTarget.values()) { if
	 * (temporaryRobotExecutorType.equals(robotType.name().toLowerCase())) {
	 * validatedTaskAttributes[1] = robotType; return; } } }
	 * 
	 * } throw new StringFormatException("Task [" + stringTask +
	 * "] can not be taken into execution. Wrong RobotExecutorType format. Do not exist type of: ["
	 * + temporaryRobotExecutorType + "]."); }
	 */

	/*private void validateMission(String tempMission) throws StringFormatException {
		if (tempMission != null) {
			for (RealTask mission : RealTask.values()) {
				if (mission.toString().toLowerCase().equals(tempMission)) {
					validatedTaskAttributes[2] = mission;
					return;
				}
			}
		}
		throw new StringFormatException("Task [" + stringTask
				+ "] can not be taken into execution. Wrong mission format. Do not exist mission: [" + tempMission
				+ "].");
	}*/

}
