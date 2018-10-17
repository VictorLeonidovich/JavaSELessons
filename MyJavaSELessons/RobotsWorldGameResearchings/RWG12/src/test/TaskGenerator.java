package test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import main.FrontController;

public class TaskGenerator implements Runnable {
	private final String[] robotTypeTargets; // = { "Builder", "Destroyer",
												// "All" };
	private final String[] missions; // = { "Build", "Destroy", "KillYourself"
										// };
	private String[] joinedArray;
	private final int tasksCount;
	private final FrontController facadeDispatcher;
	// private RobotGenerator robotGenerator;
	private Log LOG = LogFactory.getLog(TaskGenerator.class);

	public TaskGenerator(int tasksCount,
			FrontController facadeDispatcher/*
												 * , RobotGenerator robotGenerator
												 */) {
		this.tasksCount = tasksCount;
		this.facadeDispatcher = facadeDispatcher;
		// this.robotGenerator = robotGenerator;
		this.robotTypeTargets = facadeDispatcher.getRobotTypesTargetsStringArray();
		//fillRobotTypeTargetsStringArray(RobotTypeTarget.values());
		this.missions = facadeDispatcher.getMissionsStringArray();
		//this.robotIds = facadeDispatcher.getRobotIdsStringArray();
	}

	// TODO repeat
	/*private void fillRobotTypeTargetsStringArray(RobotTypeTarget[] robotTypeTargetArray) {
		int index = 0;
		for (RobotTypeTarget temporaryRobotTypeTarget : robotTypeTargetArray) {
			this.robotTypeTargets[index] = temporaryRobotTypeTarget.toString().toLowerCase();
			index++;
		}
	}*/

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
		return 50 + ":" + null + ":" + getRandomTask();// TODO
	}

	private String generateTaskWithSpacesAndUpperCase() {
		return 51 + " : " + getRandomRobotTypeOrIdOfConcreteRobot().toUpperCase() + " : " + getRandomTask().toUpperCase();
	}

	private String generateMissionExceptionTask() {
		return 50 + ":" + getRandomRobotTypeOrIdOfConcreteRobot() + ":6" + getRandomTask();
	}

	private String generateRobotTypeExceptionTask() {
		return 50 + ":" + getRandomRobotTypeOrIdOfConcreteRobot() + ".:" + getRandomTask();
	}

	private String generateIdExceptionTask() {
		return "g" + 50 + ":" + getRandomRobotTypeOrIdOfConcreteRobot() + ":" + getRandomTask();
	}

	private String generateTask(int id) {
		String randomRobotTypeOrIdOfConcreteRobot = getRandomRobotTypeOrIdOfConcreteRobot();
		LOG.debug("randomRobotTypeOrIdOfConcreteRobot=" + randomRobotTypeOrIdOfConcreteRobot);
		return id + ":" + getRandomRobotTypeOrIdOfConcreteRobot() + ":" + getRandomTask();
	}

	// TODO repeat
	private String getRandomRobotTypeOrIdOfConcreteRobot() {
		String[] robotIdsStringArray = facadeDispatcher.getRobotIdsStringArray();
		joinedArray = new String[robotIdsStringArray.length + robotTypeTargets.length];
		return joinedArray[getRandomIndexOfStringArray(joinTwoArraysToOneArray(robotIdsStringArray, robotTypeTargets))];
	}

	private String[] joinTwoArraysToOneArray(String[] robotIdsStringArray, String[] robotTypeTargets) {
		LOG.debug("joinedArray.length=" + joinedArray.length);
		int count = 0;
		for (int i = 0; i < joinedArray.length; i++) {
			if (i < robotIdsStringArray.length) {
				joinedArray[i] = robotIdsStringArray[i];
			}else {
				joinedArray[i] = robotTypeTargets[count];
				count++;
			}
		}
		LOG.debug("joinedArray=" + Arrays.toString(joinedArray));
		return joinedArray;
	}

	// TODO repeat
	private String getRandomTask() {
		return missions[getRandomIndexOfStringArray(missions)];
	}

	// TODO repeat
	private int getRandomIndexOfStringArray(String[] stringArray) {
		int random = (int) (Math.random() * stringArray.length);
		LOG.debug("stringArray[" + random + "]=" + stringArray[random]);
		return random;
	}

}
