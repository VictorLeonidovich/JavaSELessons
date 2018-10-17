package test;

import java.util.concurrent.TimeUnit;

import main.FacadeDispatcher;

public class TaskGenerator implements Runnable {
	private final String[] robotTypes = { "Builder", "Destroyer", "All" };
	private final String[] tasks = { "Build", "Destroy", "KillYourself" };
	private final int tasksCount;
	private final FacadeDispatcher facadeDispatcher;

	public TaskGenerator(int tasksCount, FacadeDispatcher facadeDispatcher) {
		this.tasksCount = tasksCount;
		this.facadeDispatcher = facadeDispatcher;
	}

	@Override
	public void run() {
		for (int i = 0; i < tasksCount; i++) {
			facadeDispatcher.addStringTask(generateTask(i));
			try {
				TimeUnit.MILLISECONDS.sleep((long) (Math.cos(i * 1000) * 250)); // new
				// Random(4000).nextLong()
				// 500 / (i + 1))
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		facadeDispatcher.addStringTask(generateIdExceptionTask());
		facadeDispatcher.addStringTask(generateRobotTypeExceptionTask());
		facadeDispatcher.addStringTask(generateMissionExceptionTask());
		facadeDispatcher.addStringTask(generateNullPointerExceptionTask());
		facadeDispatcher.addStringTask(generateNotEquals2ExceptionTask());
		facadeDispatcher.addStringTask(generateTaskWithSpacesAndUpperCase());
	}

	private String generateNotEquals2ExceptionTask() {
		return 50 + ":";
	}

	private String generateNullPointerExceptionTask() {
		return 50 + ":" + null + ":"+ getRandomTask();//TODO
	}

	private String generateTaskWithSpacesAndUpperCase() {
		return 51 + " : " + getRandomRobotType().toUpperCase() + " : " + getRandomTask().toUpperCase();
	}

	private String generateMissionExceptionTask() {
		return 50 + ":" + getRandomRobotType() + ":6" + getRandomTask();
	}

	private String generateRobotTypeExceptionTask() {
		return 50 + ":" + getRandomRobotType() + ".:" + getRandomTask();
	}

	private String generateIdExceptionTask() {
		return "g" + 50 + ":" + getRandomRobotType() + ":" + getRandomTask();
	}

	private String generateTask(int id) {
		return id + ":" + getRandomRobotType() + ":" + getRandomTask();
	}

	private String getRandomRobotType() {
		return robotTypes[getRandomIndexOfStringArray(robotTypes)];
	}

	private String getRandomTask() {
		return tasks[getRandomIndexOfStringArray(tasks)];
	}

	private int getRandomIndexOfStringArray(String[] stringArray) {
		return (int) (Math.random() * stringArray.length);
	}

}
