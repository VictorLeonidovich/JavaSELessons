package main;

import java.util.concurrent.TimeUnit;

public class Robot implements Runnable {
	private final long id;
	private final Tasks tasks;
	private boolean isAlive;

	public Robot(long id, Tasks tasks) {
		this.id = id;
		this.tasks = tasks;
		this.isAlive = true;
	}

	public long getId() {
		return id;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public void run() {
		while (isAlive) {
			if (tasks.hasNextTask()) {

			}

			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				System.err.printf("Robot id = %d was interrupted in run.", this.getId());
				e.printStackTrace();
				return;
			}
		}
		System.err.printf("Robot id = %d was killed.", this.getId());
	}

	public void doTask() {
		System.out.printf("Robot id = %d start to do the Task with id = %d.", this.getId(),
				tasks.getNextTask().getId());
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			System.err.printf(
					"Robot id = %d can not do the Task with id = %d because of InterruptException in doTask().",
					this.getId(), tasks.getNextTask().getId());
			e.printStackTrace();
		}
		System.out.printf("Robot id = %d has been done the Task with id = %d.", this.getId(),
				tasks.getNextTask().getId());
	}

}
