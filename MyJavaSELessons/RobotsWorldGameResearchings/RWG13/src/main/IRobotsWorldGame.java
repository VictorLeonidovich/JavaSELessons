package main;

public interface IRobotsWorldGame {
public void addRobot(String robotType);
//TODO to delete ---String taskType,
public void addArithmeticalTaskToConcreteRobot(String robotId, String taskType, String digits);
public void addKillYourselfTaskToConcreteRobot(String id);
//TODO to delete ---String taskType,
public void addArithmeticalTaskToAllRobots(String taskType, String digits);
public void addKillYourselfTaskToAllRobots();

}
