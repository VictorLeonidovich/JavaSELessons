package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ObjectsFactory {
	private final Queue<Log> defaultLogStorage = new PriorityQueue<>();
	private final List<Robot> defaultRobotsStorage = new ArrayList<>();
	private final Queue<Task> defaultTasksStorage = new PriorityQueue<>();
	private final Logs logs;
	private final Robots robots;
	private final Tasks tasks;

	public ObjectsFactory() {
		this.logs = new Logs(this, defaultLogStorage);
		this.robots = new Robots(this, logs, defaultRobotsStorage);
		this.tasks = new Tasks(this, logs, defaultTasksStorage);
	}

	public Logs getLogs() {
		return logs;
	}

	public Robots getRobots() {
		return robots;
	}

	public Tasks getTasks() {
		return tasks;
	}

	public Log createLog(String message, Date date) {
		return new Log(message, date);
	}

	public Robot createRobot(long id) {
		return new Robot(String.valueOf(id), getLogs(), getTasks());
	}

	public Task createTask(long id) {
		return new Task(id);
	}

}
