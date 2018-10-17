package main;

import java.util.concurrent.CopyOnWriteArrayList;

public class Robots {
	private final CopyOnWriteArrayList<Robot> robots;
	private long robotsCount;
	private Tasks tasks;

	public CopyOnWriteArrayList<Robot> getRobots() {
		return robots;
	}

	public Robots(CopyOnWriteArrayList<Robot> robots, Tasks tasks) {
		this.robots = robots;
		this.tasks = tasks;
		this.robotsCount = 0;
	}

	public void addRobotById(long id) {
		robots.add(new Robot(id, tasks));
		this.robotsCount++;
	}

	public void killRobot() {
		this.robotsCount--;
	};

}
