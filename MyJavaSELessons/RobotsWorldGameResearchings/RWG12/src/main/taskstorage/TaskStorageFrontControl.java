package main.taskstorage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import main.GameController;
import main.RealTask;
import main.RobotTypeUtils;

public class TaskStorageFrontControl implements ITaskStorage {
	private final StringTaskTransformationControl stringTaskTransformationControl;
	private final PersonalTaskStorage personalTaskStorage;
	private final TypifiedTaskStorage typifiedTaskStorage;
	private final Log log = LogFactory.getLog(TaskStorageFrontControl.class);

	public TaskStorageFrontControl(StringTaskTransformationControl stringTaskTransformationControl,
			PersonalTaskStorage personalTaskStorage, TypifiedTaskStorage typifiedTaskStorage) {
		this.stringTaskTransformationControl = stringTaskTransformationControl;
		this.personalTaskStorage = personalTaskStorage;
		this.typifiedTaskStorage = typifiedTaskStorage;
	}

	@Override
	public void addTaskByStringMission(String stringMission) throws StringFormatException {
		log.debug("Try to send stringMission=[" + stringMission + "] to StringTaskTransformationControl.");
		stringTaskTransformationControl.addTaskByStringMission(stringMission);
	}

	@Override
	public RealTask getTaskByRobotId(int robotId) throws NoTaskException {
		log.debug("Try to get the task by robot id=" + robotId + " from PersonalTaskStorage.");
		return personalTaskStorage.getTaskByRobotId(robotId);
	}

	@Override
	public RealTask getTaskByRobotType(RobotTypeUtils robotType) throws NoTaskException {
		log.debug("Try to get the task by robot type=" + robotType + " from TypifiedTaskStorage.");
		return typifiedTaskStorage.getTaskByRobotType(robotType);
	}

}
