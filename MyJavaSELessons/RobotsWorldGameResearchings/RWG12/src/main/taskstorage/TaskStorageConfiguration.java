package main.taskstorage;

import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

import main.RealTask;
import main.RobotTypeUtils;

public class TaskStorageConfiguration {
	private final Map<Integer, Deque<RealTask>> mappedPersonalTaskStorage;
	private final Map<Integer, AtomicInteger> mappedPersonalTaskAmountStorage;
	private final Map<RobotTypeUtils, Deque<RealTask>> mappedTypifiedTaskStorage;
	private final Map<RobotTypeUtils, AtomicInteger> mappedTypifiedTaskAmountStorage;
	private final PersonalTaskStorage personalTaskStorage;
	private final TypifiedTaskStorage typifiedTaskStorage;
	private final TaskValidation taskValidation;
	private final TaskStorageFrontControl taskStorageFrontControl;
	private final StringTaskTransformationControl stringTaskTransformationControl;

	public TaskStorageConfiguration() {
		this.mappedPersonalTaskStorage = new ConcurrentSkipListMap<>();
		this.mappedPersonalTaskAmountStorage = new ConcurrentSkipListMap<>();
		this.mappedTypifiedTaskStorage = new ConcurrentSkipListMap<>();
		this.mappedTypifiedTaskAmountStorage = new ConcurrentSkipListMap<>();
		this.personalTaskStorage = new PersonalTaskStorage(this.mappedPersonalTaskStorage, this.mappedPersonalTaskAmountStorage);
		this.typifiedTaskStorage = new TypifiedTaskStorage(this.mappedTypifiedTaskStorage, this.mappedTypifiedTaskAmountStorage);
		this.taskValidation = new TaskValidation();
		this.stringTaskTransformationControl = new StringTaskTransformationControl(this.taskValidation,
				this.personalTaskStorage, this.typifiedTaskStorage);
		this.taskStorageFrontControl = new TaskStorageFrontControl(this.stringTaskTransformationControl,
				this.personalTaskStorage, this.typifiedTaskStorage);
	}

	public TaskStorageFrontControl getTaskStorageFrontControl() {
		return taskStorageFrontControl;
	}
}
