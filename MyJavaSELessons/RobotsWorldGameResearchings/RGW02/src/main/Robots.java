package main;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Robots {
	private final ObjectsFactory objectsFactory;
	private final Logs logs;
	private final List<Robot> robots;
	ExecutorService robotsExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	// private final List<Thread> aliveRobots = new ArrayList<>();
	private long robotsCount;

	public Robots(ObjectsFactory objectsFactory, Logs logs, List<Robot> robots) {
		this.objectsFactory = objectsFactory;
		this.logs = logs;
		this.robots = robots;
		this.robotsCount = 0L;
	}

	public Robot addRobot() {
		Robot robot;
		robots.add(robot = objectsFactory.createRobot(++robotsCount));
		return robot;
	}

	public void startRobots() {		
		for (Robot robot : robots) {
			robotsExecutor.execute(robot);
		}
		try {
			robotsExecutor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robotsExecutor.shutdown();
	}
	
}
