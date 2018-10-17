package main.taskstorage;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

import main.RealTask;
import main.RobotTypeTarget;
import main.RobotTypeUtils;

public class TypifiedTaskStorage {
	private final Map<RobotTypeUtils, Deque<RealTask>> mappedTypifiedTaskStorage;
	private final Map<RobotTypeUtils, AtomicInteger> mappedTypifiedTaskAmountStorage;

	public TypifiedTaskStorage(Map<RobotTypeUtils, Deque<RealTask>> mappedTypifiedTaskStorage,
			Map<RobotTypeUtils, AtomicInteger> mappedTypifiedTaskAmountStorage) {
		this.mappedTypifiedTaskStorage = mappedTypifiedTaskStorage;
		this.mappedTypifiedTaskAmountStorage = mappedTypifiedTaskAmountStorage;
	}

	public synchronized void distributeTasks(List<RobotTypeTarget> robotTypeTargets, List<RealTask> tasks) {
		for (RobotTypeTarget robotIdsTarget : robotTypeTargets) {
			List<RobotTypeUtils> robotTypes = robotIdsTarget.getRobotType();
			for (RobotTypeUtils robotType : robotTypes) {
				if (!mappedTypifiedTaskStorage.containsKey(robotType)) {
					mappedTypifiedTaskStorage.put(robotType, new ConcurrentLinkedDeque<>());
					mappedTypifiedTaskAmountStorage.put(robotType, new AtomicInteger(0));
				}
				addTasksToStorage(robotType, tasks);
			}
		}
	}

	private void addTasksToStorage(RobotTypeUtils robotType, List<RealTask> tasks) {
		for (RealTask task : tasks) {
			mappedTypifiedTaskStorage.get(robotType).addFirst(task);
			increaseTaskAmount(robotType);
		}

	}

	private void increaseTaskAmount(RobotTypeUtils robotType) {
		mappedTypifiedTaskAmountStorage.get(robotType).getAndIncrement();
	}

	public synchronized RealTask getTaskByRobotType(RobotTypeUtils robotType) throws NoTaskException {
		RealTask task;
		if (mappedTypifiedTaskAmountStorage.containsKey(robotType)) {
			if (mappedTypifiedTaskAmountStorage.get(robotType).get() > 0) {
				task = mappedTypifiedTaskStorage.get(robotType).pollLast();
				decreaseTaskAmount(robotType);
				return task;
			}
		}
		throw new NoTaskException(robotType);
	}

	private void decreaseTaskAmount(RobotTypeUtils robotType) {
		mappedTypifiedTaskAmountStorage.get(robotType).getAndDecrement();
	}

}
