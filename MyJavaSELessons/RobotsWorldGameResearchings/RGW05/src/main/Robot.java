package main;

import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Robot implements Runnable {
	//private volatile Deque<Task> tasksStorage;
	private volatile Deque<String> logsStorage;
	private final ThreadLocal<Long> id;
	private final ThreadLocal<RobotType> robotType;

	public Robot(final long id, RobotType robotType, /*Deque<Task> tasksStorage, */Deque<String> logsStorage) {
		//this.tasksStorage = tasksStorage;
		this.logsStorage = logsStorage;
		this.id = new ThreadLocal<Long>() {
			@Override
			protected Long initialValue() {
				return id;
			}
		};
		this.robotType = new ThreadLocal<RobotType>() {
			@Override
			protected RobotType initialValue() {
				return robotType;
			}
		};
		logsStorage.addFirst(this.toString() + " was created.");
	}

	public void doTask() {
		Task task = this.robotType.get().pollTask();

		int restTasks = this.robotType.get().getSize();
		if (task != null) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logsStorage.addFirst(this.toString() + " have been done the Task [" + task.toString()
					+ "] successfully. Time: " + System.currentTimeMillis() + " ms. Rest Tasks: " + restTasks);
		}
	}

	@Override
	public void run() {
		while (true) {
			doTask();
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "Robot [id=" + id.get() + ", robotType=" + robotType.get() + "]";
	}

}
