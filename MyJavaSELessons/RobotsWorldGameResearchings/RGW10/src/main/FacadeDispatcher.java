package main;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

import main.logstorage.ILogStorage;
import main.logstorage.LogStorage;
import main.taskmanagement.StringTaskFormatException;
import main.taskmanagement.TaskDistribution;
import main.taskmanagement.TaskCreation;
import main.taskmanagement.TaskValidation;

public class FacadeDispatcher implements IRobotsGameWorld, ITasksAndRobotsAware {// FacadeController
	private final GameController gameController;
	private final ILogStorage logsStorage;
	private final TaskValidation validator;
	private final TaskCreation taskCreation;
	private final TaskDistribution taskDistribution;
	private final List<Robot> robots;
	private final RobotsFactory robotsFactory;

	// TODO Configuration.class
	public FacadeDispatcher() {
		this.logsStorage = new LogStorage(new ConcurrentLinkedDeque<>());
		this.robots = new CopyOnWriteArrayList<Robot>();
		this.robotsFactory = new RobotsFactory(robots);		
		this.taskDistribution = new TaskDistribution(robots);
		this.taskCreation = new TaskCreation(this.taskDistribution);
		this.validator = new TaskValidation(this.taskCreation);
		this.gameController = new GameController(this.logsStorage, /*this.validator,*/ this.robotsFactory);
	}

	@Override
	public synchronized void addStringTask(String stringTask) {
		try {
			validator.validateStringTask(stringTask);			
		} catch (StringTaskFormatException e) {
			logsStorage.addStringLog(e.getMessage() + " Please correct the mistake and try again.");
		}
	}

	@Override
	public String getStringLog() {
		return logsStorage.getStringLog();
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
		return logsStorage.getAllStringLogs();
	}

}
