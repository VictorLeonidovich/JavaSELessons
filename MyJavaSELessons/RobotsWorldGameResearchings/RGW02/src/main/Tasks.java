package main;

import java.util.Queue;

public class Tasks {
	private final ObjectsFactory objectsFactory;
	private final Queue<Task> tasks;
	private final Logs logs;

	public Tasks(ObjectsFactory objectsFactory, Logs logs, Queue<Task> tasks) {
		this.objectsFactory = objectsFactory;
		this.logs = logs;
		this.tasks = tasks;
	}

	public void addTask(long id) {
		Task task = createTask(id);
		tasks.add(task);
		logs.addLog("Task id=" + id + " was appeared.", task.getDate());
	}

	private Task createTask(long id) {
		return objectsFactory.createTask(id);
	}

	public Task getTask() {
		return this.tasks.poll();
	}

	public boolean hasTask() {
		return !tasks.isEmpty();
	}

	public int getCount() {
		return tasks.size();
	}

}
