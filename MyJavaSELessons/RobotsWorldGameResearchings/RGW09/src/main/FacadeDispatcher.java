package main;

import java.util.ArrayList;
import java.util.List;

public class FacadeDispatcher implements IRobotsGameWorld, ITasksAndRobotsAware {// FacadeController
	private GameController gameController;

	public FacadeDispatcher() {
		this.gameController = new GameController();
	}

	@Override
	public synchronized void addStringTask(String stringTask) {
		gameController.notifyActivityTrackerAboutAppearedTask(stringTask);
	}

	@Override
	public String getStringLog() {
		String log = gameController.pollLastLog();
		if (log == null) {
			log = "no message.";
		}
		return log;
	}

	@Override
	public void addOwnRobot(String stringRobotType) {
		if (stringRobotType != null) {
			gameController.needNewRobotWithType(validateRobotType(stringRobotType));
		} else {
			// TODO exception
		}
	}

	// TODO move logic to RobotTypeUtils.class
	private RobotTypeUtils validateRobotType(String stringRobotType) {
		for (RobotTypeUtils temporaryRobotType : RobotTypeUtils.values()) {
			if (stringRobotType.trim().toLowerCase().equals(temporaryRobotType.toString().toLowerCase())) {
				return temporaryRobotType;
			}
		}
		// TODO
		return null;// throw new Exception("Not exist sush robot type = " +
					// stringRobotType);
	}

	@Override
	public String[] getRobotTypesStringArray() {
		String[] robotTypes = new String[RobotTypeUtils.values().length];
		return fillRobotTypesStringArray(robotTypes, RobotTypeUtils.values());
	}

	// TODO repeat
	private String[] fillRobotTypesStringArray(String[] robotTypes, RobotTypeUtils[] robotType) {
		int index = 0;
		for (RobotTypeUtils temporaryRobotType : robotType) {
			robotTypes[index] = temporaryRobotType.toString().toLowerCase();
			index++;
		}
		return robotTypes;
	}

	@Override
	public String[] getMissionsStringArray() {
		String[] stringMissions = new String[Mission.values().length];
		return fillMissionsStringArray(stringMissions, Mission.values());
	}

	// TODO repeat
	private String[] fillMissionsStringArray(String[] stringMissions, Mission[] missions) {
		int index = 0;
		for (Mission temporaryMission : missions) {
			stringMissions[index] = temporaryMission.toString().toLowerCase();
			index++;
		}
		return stringMissions;
	}

	@Override
	public String[] getRobotTypesTargetsStringArray() {
		String[] robotTypeTargets = new String[RobotTypeTarget.values().length];
		return fillRobotTypeTargetsStringArray(robotTypeTargets, RobotTypeTarget.values());
	}

	private String[] fillRobotTypeTargetsStringArray(String[] robotTypeTargets,
			RobotTypeTarget[] robotTypeTargetArray) {
		int index = 0;
		for (RobotTypeTarget temporaryRobotTypeTarget : robotTypeTargetArray) {
			robotTypeTargets[index] = temporaryRobotTypeTarget.toString().toLowerCase();
			index++;
		}
		return robotTypeTargets;
	}

	@Override
	public String[] getRobotIdsStringArray() {
		long robotsAmount = 0;
		for (RobotTypeUtils robotType : RobotTypeUtils.values()) {
			robotsAmount = robotsAmount + robotType.getRobotsAmount();
		}
		String[] robotIds = new String[(int) robotsAmount];// bad casting
		for (long i = 0; i < robotIds.length; i++) {
			robotIds[(int) i] = String.valueOf(i + 1);// bad casting
		}
		return robotIds;
	}

	@Override
	public List<String> getAllStringLog() {
		List<String> logs = new ArrayList<>();
		String log;
		while ((log = getStringLog()) != "no message.") {
			logs.add(log);
		}
		return logs;
	}

}
