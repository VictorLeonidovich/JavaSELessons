package main.taskstorage;

import main.RobotTypeUtils;

public class NoTaskException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoTaskException(int robotId) {
		super("No task for robot's id = " + robotId);
	}

	public NoTaskException(RobotTypeUtils robotType) {
		super("No task for robot's type = " + robotType);
	}

}
