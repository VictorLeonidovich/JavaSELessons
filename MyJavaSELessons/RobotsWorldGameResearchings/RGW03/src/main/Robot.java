package main;

import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Robot implements Runnable {
	private static volatile AtomicLong robotsCount = new AtomicLong(0);
	private volatile Deque<String> tasksStorage;
	private volatile Deque<String> logsStorage;
	private volatile ThreadLocal<Long> id = new ThreadLocal<Long>() {
		@Override
		protected Long initialValue() {
			return robotsCount.get();
		}
	};

	public Robot(long id, Deque<String> tasksStorage, Deque<String> logsStorage) {
		this.tasksStorage = tasksStorage;
		this.logsStorage = logsStorage;
		robotsCount.set(id);
		this.id.set(id);
		logsStorage.addFirst("Robot id=" + this.id.get() + " was created.");
	}

	public void doTask() {
		String task = tasksStorage.pollLast();
		int restTasks = tasksStorage.size();
		if (task != null) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logsStorage.addFirst("Robot id=" + this.id.get() + " have been done " + task + " successfully. Time: "
					+ System.currentTimeMillis() + " ms. Rest Tasks: " + restTasks);
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

}
