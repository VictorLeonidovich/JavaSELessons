package main;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ActivityTracker implements Runnable {
	private GameController gameController;
	private Log LOG = LogFactory.getLog(ActivityTracker.class);

	public ActivityTracker(GameController gameController) {
		this.gameController = gameController;
	}

	private void checkRobotsActivity() {
		for (RobotTypeUtils robotExecutorType : RobotTypeUtils.values()) {
			if (hasNoRobot(robotExecutorType) || isHighRobotsActivity(robotExecutorType)) {
				gameController.needNewRobotWithType(robotExecutorType);
			}
		}
	}

	private boolean isHighRobotsActivity(RobotTypeUtils robotExecutorType) {
		long tasksAmount = robotExecutorType.getTasksAmount();
		long robotsAmount = robotExecutorType.getRobotsAmount();
		boolean isHighRobotsActivity = robotExecutorType.getTasksAmount() > robotExecutorType.getRobotsAmount();
		LOG.debug("For RobotType=" + robotExecutorType + " isHighRobotsActivity=" + isHighRobotsActivity
				+ ", tasksAmount=" + tasksAmount + ", robotsAmount=" + robotsAmount);
		return isHighRobotsActivity;
	}

	private boolean hasNoRobot(RobotTypeUtils robotExecutorType) { // TODO
																// hasRobot()?
		return robotExecutorType.hasNoRobot(robotExecutorType);
	}

	@Override
	public void run() {
		while (true) {
			checkRobotsActivity();
			checkRobotsIsAlive();
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void checkRobotsIsAlive() {
		gameController.startDiedRobot();
		
	}

}
