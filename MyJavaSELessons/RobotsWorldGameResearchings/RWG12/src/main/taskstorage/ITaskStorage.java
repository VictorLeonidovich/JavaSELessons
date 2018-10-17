package main.taskstorage;

import main.RealTask;
import main.RobotTypeUtils;

public interface ITaskStorage {
	public void addTaskByStringMission(String stringMission) throws StringFormatException;
	//public void addTaskByStringRobotId(String stringRobotId); // return boolean
																// for
																// transactions

	//public void addTaskByStringRobotType(String stringRobotType); // return
																	// boolean
																	// for
																	// transactions

	public RealTask getTaskByRobotId(int robotId) throws NoTaskException;

	public RealTask getTaskByRobotType(RobotTypeUtils robotType) throws NoTaskException;
}
