package main;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Robot implements Runnable {
	private final String id;
	private final Logs logs;
	private final Tasks tasks;
	private final Object lock = new Object();

	public Robot(String id, Logs logs, Tasks tasks) {
		this.id = id;
		this.logs = logs;
		this.tasks = tasks;
		logs.addLog("New Robot successfully created: id = " + id, new Date());
	}

	@Override
	public void run() {
		synchronized (lock) {
			if (tasks.hasTask()) {				
				long taskId = tasks.getTask().getId();
				logs.addLog("Robot: id = " + id + " starting to do the Task id=" + taskId, new Date());
				doTask(taskId);
				logs.addLog("Robot: id = " + id + " did the Task id=" + taskId + " succesfully!", new Date());
			}
		}
	}

	private synchronized void doTask(long taskId) {
		logs.addLog("Robot: id = " + id + " doing the Task id=" + taskId, new Date());
		try {
			TimeUnit.MILLISECONDS.sleep(250);
		} catch (InterruptedException e) {
			logs.addLog("Robot: id = " + id + " was interrupted while doing the Task id=" + taskId
					+ "! It's need to do transactions...", new Date());
			e.printStackTrace();
		}
	}

}
