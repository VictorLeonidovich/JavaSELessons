package main.robotmanagement;

import main.RobotTypeUtils;
import main.taskmanagement.StringFormatException;

public class RobotTypeValidation {

	private final RobotCreation robotCreation;

	public RobotTypeValidation(RobotCreation robotCreation) {
		this.robotCreation = robotCreation;
	}

	public void validateRobotType(String stringRobotType) throws StringFormatException {
		for (RobotTypeUtils temporaryRobotType : RobotTypeUtils.values()) {
			if (stringRobotType.trim().toLowerCase().equals(temporaryRobotType.toString().toLowerCase())) {
				robotCreation.createRobotByType(temporaryRobotType);
				return;
			}
		}
		throw new StringFormatException("Robot [" + stringRobotType
				+ "] can not be created. Wrong robot type format. It does not exist.");
		
	}

}
