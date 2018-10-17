package test;

import java.util.concurrent.TimeUnit;

import main.FacadeDispatcher;

public class TaskGenerator implements Runnable {

	private final int tasksCount;
	private final FacadeDispatcher facadeDispatcher;

	public TaskGenerator(int tasksCount, FacadeDispatcher facadeDispatcher) {
		this.tasksCount = tasksCount;
		this.facadeDispatcher = facadeDispatcher;
	}

	@Override
	public void run() {
		for (int i = 0; i < tasksCount; i++) {
			facadeDispatcher.addStringTask(generateTask(i));
			try {
				TimeUnit.MILLISECONDS.sleep(500/(i + 1)); // new Random(4000).nextLong()//500/(i + 1)
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private String generateTask(int id) {
		return "Task-" + id;
	}

}
