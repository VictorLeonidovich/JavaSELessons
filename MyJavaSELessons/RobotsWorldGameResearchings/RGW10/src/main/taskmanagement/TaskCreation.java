package main.taskmanagement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import main.Mission;
import main.RobotTypeTarget;
import main.RobotTypeUtils;

public class TaskCreation {
	// message задайте формат задачи правильно...
	// private String[] parsedStringTask;
	
	private final TaskDistribution taskDistribution;
	private Log LOG = LogFactory.getLog(TaskCreation.class);
	
	public TaskCreation(TaskDistribution taskDistribution) {
		this.taskDistribution = taskDistribution;
	}

	public /*Task[]*/ void createTask(Object[] validatedTaskAttributes) {
		//LOG.debug("validatedTaskAttributes=" + validatedTaskAttributes);
		Task[] tasks = null;
		Integer id;
		//LOG.debug("validatedTaskAttributes[0]=" + validatedTaskAttributes[0]);
		if (validatedTaskAttributes[0] instanceof Integer) {
			id = (Integer) validatedTaskAttributes[0];
		} else {
			//TODO 
			throw new UnsupportedOperationException("createTask");
		}
		Mission mission;
		if (validatedTaskAttributes[2] instanceof Mission) {
			mission = (Mission) validatedTaskAttributes[2];
		} else {
			//TODO
			throw new UnsupportedOperationException("createTask");
		}
		Object robotTarget = validatedTaskAttributes[1];
		if (id > 0 || mission != null) {
			if (robotTarget instanceof Integer) {
				tasks = new Task[1];
				tasks[0] = new Task(id, null, (Integer) robotTarget, mission);
				taskDistribution.distributeTasks(tasks);
				//return tasks;
				return;//TODO delete after delete of Exception
			}
			if (robotTarget instanceof RobotTypeTarget) {
				if (RobotTypeTarget.ALL.equals((RobotTypeTarget) robotTarget)) {
					int count = 0;
					tasks = new Task[RobotTypeUtils.values().length];
					for (RobotTypeTarget robotExecutorType : RobotTypeTarget.values()) {
						if (robotExecutorType.equals(RobotTypeTarget.ALL)) {
							continue;
						}
						tasks[count] = new Task(id, robotExecutorType, null, mission);
						count++;
					}
					taskDistribution.distributeTasks(tasks);
					//return tasks;
					return;//TODO delete after delete of Exception
				} else {
					tasks = new Task[1];
					tasks[0] = new Task(id, (RobotTypeTarget) robotTarget, null, mission);
					taskDistribution.distributeTasks(tasks);
					//return tasks;
					return; //TODO delete after delete of Exception
				}
			}
		}
		throw new UnsupportedOperationException("createTask"); //TODO delete Exception
	}
	

}
