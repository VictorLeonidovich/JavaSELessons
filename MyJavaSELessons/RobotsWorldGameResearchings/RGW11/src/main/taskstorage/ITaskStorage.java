package main.taskstorage;

public interface ITaskStorage {
public void addTaskByStringRobotId(String stringRobotId); //return boolean for transactions
public void addTaskByStringRobotType(String stringRobotType); //return boolean for transactions
public String getTaskByStringRobotId(String stringRobotId);
public String getTaskByStringRobotType(String stringRobotType);
}
