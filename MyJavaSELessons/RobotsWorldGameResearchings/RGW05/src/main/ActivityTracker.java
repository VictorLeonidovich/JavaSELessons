package main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ActivityTracker {
	private GameController gameController;
	private Log LOG = LogFactory.getLog(ActivityTracker.class);

	public ActivityTracker(GameController gameController) {
		this.gameController = gameController;
	}

	public void notifyAboutAppearedTask(String stringTask) {
		checkRobotsActivity();
	}

	private void checkRobotsActivity() {
		for (RobotType robotExecutorType : RobotType.values()) {
			if (hasNoRobot(robotExecutorType) || isHighRobotsActivity(robotExecutorType)) {
				gameController.needNewRobotWithType(robotExecutorType);
			}
		}
	}

	private boolean isHighRobotsActivity(RobotType robotExecutorType) {
		return robotExecutorType.getTasksAmount() > robotExecutorType.getRobotsAmount();
	}

	private boolean hasNoRobot(RobotType robotExecutorType) { // TODO
																// hasRobot()?
		return robotExecutorType.hasNoRobot(robotExecutorType);
	}

}
