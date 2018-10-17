package main;

import java.util.concurrent.BlockingQueue;

public class Tasks {
	private final BlockingQueue<Task> tasks;
	private long taskCounter;

	public Tasks(BlockingQueue<Task> tasks) {
		this.tasks = tasks;
		this.taskCounter = 0;
	}

	public boolean hasNextTask() {
		if (tasks.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public Task getNextTask() {

		return null;
	}

	public void addNextTaskById(long id) {
		tasks.add(new Task(id));
		this.taskCounter++;
	}

	public Task getTask() {
		return new Task(1L);
	}

}
