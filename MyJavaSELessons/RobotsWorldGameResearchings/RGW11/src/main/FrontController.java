package main;

import java.util.List;

public class FrontController implements IRobotsGameWorld, ITasksAndRobotsAware {// FacadeController
	private GameController gameController;
	private final GameConfiguration gameConfiguration;

	public FrontController() {
		gameConfiguration = new GameConfiguration(this);
	}

	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public synchronized void addStringTask(String stringTask) {
		gameController.validateStringTask(stringTask);

	}

	@Override
	public String getStringLog() {
		return gameController.getStringLog();
	}

	@Override
	public List<String> getAllStringLog() {
		return gameController.getAllStringLogs();
	}

	@Override
	public void addOwnRobot(String stringRobotType) {
		if (stringRobotType != null) {
			gameController.validateRobotType(stringRobotType);
			//gameController.needNewRobotWithType(validateRobotType(stringRobotType));
		} /*else {
			// TODO exception
		}*/
	}

	// TODO move logic to RobotTypeUtils.class
	/*private RobotTypeUtils validateRobotType(String stringRobotType) {
		for (RobotTypeUtils temporaryRobotType : RobotTypeUtils.values()) {
			if (stringRobotType.trim().toLowerCase().equals(temporaryRobotType.toString().toLowerCase())) {
				return temporaryRobotType;
			}
		}
		// TODO
		return null;// throw new Exception("Not exist sush robot type = " +
					// stringRobotType);
	}*/

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
		String[] stringMissions = new String[RealTask.values().length];
		return fillMissionsStringArray(stringMissions, RealTask.values());
	}

	// TODO repeat
	private String[] fillMissionsStringArray(String[] stringMissions, RealTask[] missions) {
		int index = 0;
		for (RealTask temporaryMission : missions) {
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
		String[] robotIds = new String[(int) robotsAmount];//TODO bad casting
		for (long i = 0; i < robotIds.length; i++) {
			robotIds[(int) i] = String.valueOf(i + 1);//TODO bad casting
		}
		return robotIds;
	}

}
