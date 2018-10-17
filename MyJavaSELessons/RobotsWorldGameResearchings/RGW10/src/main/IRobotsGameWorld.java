package main;

import java.util.List;

public interface IRobotsGameWorld {
	public void addStringTask(String stringTask);

	public String getStringLog();

	public List<String> getAllStringLog();

	public void addOwnRobot(String stringRobotType);
}
