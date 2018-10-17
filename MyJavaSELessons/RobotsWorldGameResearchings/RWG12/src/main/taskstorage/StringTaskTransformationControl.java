package main.taskstorage;

import java.util.List;

import main.RealTask;
import main.RobotTypeTarget;
import main.RobotTypeUtils;

public class StringTaskTransformationControl {
	private final TaskValidation taskValidation;
	private final PersonalTaskStorage personalTaskStorage;
	private final TypifiedTaskStorage typifiedTaskStorage;

	public StringTaskTransformationControl(TaskValidation taskValidation, PersonalTaskStorage personalTaskStorage,
			TypifiedTaskStorage typifiedTaskStorage) {
		this.taskValidation = taskValidation;
		this.personalTaskStorage = personalTaskStorage;
		this.typifiedTaskStorage = typifiedTaskStorage;
	}

	public void addTaskByStringMission(String stringMission) throws StringFormatException {
		String notNullStringMission = taskValidation.validateNotNull(stringMission);
		String[] parsedStringMissionAttributes = taskValidation.parseStringMission(notNullStringMission);
		taskValidation.validateMissionAttributesAmount(parsedStringMissionAttributes, stringMission);
		String[] stringMissionAttributes = taskValidation.prepareStringMissionAttributes(parsedStringMissionAttributes);
		//TODO reserved
		int[] missionIds = taskValidation.validateId(stringMissionAttributes[0], stringMission);
		String targets = stringMissionAttributes[1];
		List<Integer> robotIdsTargets = taskValidation.getRobotIdsTargets(targets);
		List<RobotTypeTarget> robotTypeTargets = taskValidation.getRobotTypesTargets(targets, stringMission);
		List<RealTask> tasks = taskValidation.validateTask(stringMissionAttributes[2], stringMission);
		personalTaskStorage.distributeTasks(robotIdsTargets, tasks);
		typifiedTaskStorage.distributeTasks(robotTypeTargets, tasks);
	}

}
