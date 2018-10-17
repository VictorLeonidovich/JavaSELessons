package test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import main.Log;
import main.Logs;
import main.ObjectsFactory;
import main.Robot;
import main.Robots;
import main.Tasks;

public class Main {
	private static ObjectsFactory objectsFactory;
	private static Robots robots;
	private static Logs logs;
	private static Tasks tasks;
	private static ExecutorService logsExecutor = Executors.newFixedThreadPool(1);

	public static void main(String[] args) {
		objectsFactory = createObjectsFactory();
		logs = objectsFactory.getLogs();
		startLogs();
		logs.addLog("First Log created", new Date());
		tasks = objectsFactory.getTasks();
		addTenTasks(10);
		addTenTasks(10);
		addTenTasks(10);
		robots = objectsFactory.getRobots();
		addTenRobots(10);
		startRobots();		
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logs.addLog("Remaining Tasks: " + tasks.getCount(), new Date());
	}

	private static void addTenTasks(int count) {
		for (int i = 0; i < count; i++) {
			tasks.addTask(i);
		}
	}

	private static void startLogs() {
		logsExecutor.execute(logs);
		logsExecutor.shutdown();
	}

	private static void startRobots() {
		for (int i = 0; i < 3; i++) {
			robots.startRobots();
		}
	}

	private static void addTenRobots(int robotsCount) {
		for (int i = 0; i < robotsCount; i++) {
			Robot robot = robots.addRobot();
		}

	}

	private static ObjectsFactory createObjectsFactory() {
		return new ObjectsFactory();
	}

}
