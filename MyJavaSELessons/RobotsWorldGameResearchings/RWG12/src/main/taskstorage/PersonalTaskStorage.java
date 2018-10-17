package main.taskstorage;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import main.RealTask;

public class PersonalTaskStorage {
	private final Map<Integer, Deque<RealTask>> mappedPersonalTaskStorage;
	private final Map<Integer, AtomicInteger> mappedPersonalTaskAmountStorage;
	private final Log log = LogFactory.getLog(PersonalTaskStorage.class);


	public PersonalTaskStorage(Map<Integer, Deque<RealTask>> mappedPersonalTaskStorage,
			Map<Integer, AtomicInteger> mappedPersonalTaskAmountStorage) {
		this.mappedPersonalTaskStorage = mappedPersonalTaskStorage;
		this.mappedPersonalTaskAmountStorage = mappedPersonalTaskAmountStorage;
	}

	public void distributeTasks(List<Integer> robotIdsTargets, List<RealTask> tasks) {
		for (Integer robotIdsTarget : robotIdsTargets) {
			if (!mappedPersonalTaskStorage.containsKey(robotIdsTarget)) {
				mappedPersonalTaskStorage.put(robotIdsTarget, new ConcurrentLinkedDeque<>());
				mappedPersonalTaskAmountStorage.put(robotIdsTarget, new AtomicInteger(0));
			}			
			addTasksToStorage(robotIdsTarget, tasks);
			log.debug("Tasks=[" + tasks + "] was succesfully added to mappedPersonalTaskStorage by robot id=" + robotIdsTarget);
		}
	}

	// TODO remove synchronized
	private synchronized void addTasksToStorage(Integer robotIdsTarget, List<RealTask> tasks) {
		for (RealTask task : tasks) {
			mappedPersonalTaskStorage.get(robotIdsTarget).addFirst(task);
			increaseTaskAmount(robotIdsTarget);
		}
	}

	private void increaseTaskAmount(Integer robotIdsTarget) {
		mappedPersonalTaskAmountStorage.get(robotIdsTarget).getAndIncrement();
		log.debug("Task amount in mappedPersonalTaskStorage was increased. Now task amount is =[" + mappedPersonalTaskAmountStorage.get(robotIdsTarget).get() + "]");
	}
// TODO  robotId->robotIdTarget
	public synchronized RealTask getTaskByRobotId(int robotId) throws NoTaskException {
		RealTask task;
		if (mappedPersonalTaskAmountStorage.containsKey(robotId)) {
			if (mappedPersonalTaskAmountStorage.get(robotId).get() > 0) {
				task = mappedPersonalTaskStorage.get(robotId).pollLast();
				decreaseTaskAmount(robotId);
				return task;
			}
		}
		throw new NoTaskException(robotId);
	}

	private void decreaseTaskAmount(int robotId) {
		mappedPersonalTaskAmountStorage.get(robotId).getAndDecrement();
		log.debug("Task amount in mappedPersonalTaskStorage was decreased. Now task amount is =[" + mappedPersonalTaskAmountStorage.get(robotId).get() + "]");
	}

}
