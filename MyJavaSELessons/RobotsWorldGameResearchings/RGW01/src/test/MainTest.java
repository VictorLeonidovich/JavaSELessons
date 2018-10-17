package test;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import main.Robot;
import main.Robots;
import main.Tasks;

public class MainTest {

	public static void main(String[] args) {
		Tasks tasks = createTasks();
		Robots robots = createRobots(tasks);
		runRobots(robots);
		runTasks(tasks);
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		killAllRobots(robots);
	}

	private static Robots createRobots(Tasks tasks) {
		Robots robots = new Robots(new CopyOnWriteArrayList<>(), tasks);
		for (long i = 0; i < 2; i++) {
			robots.addRobotById(i);
		}

		return robots;

	}

	private static void killAllRobots(Robots robots) {
		for (Robot robot : robots.getRobots()) {
			robot.setIsAlive(false);
		robots.killRobot();	
		}
		
	}

	private static void runTasks(Tasks tasks) {
		// TODO Auto-generated method stub

	}

	private static Tasks createTasks() {
		Tasks tasks = new Tasks(new LinkedBlockingQueue<>());
		return tasks;
	}

	private static void runRobots(Robots robots) {
		for (Robot robot : robots.getRobots()) {
			Thread thread = new Thread(robot);
			thread.setDaemon(true);
			thread.start();
		}
		
	}

}
