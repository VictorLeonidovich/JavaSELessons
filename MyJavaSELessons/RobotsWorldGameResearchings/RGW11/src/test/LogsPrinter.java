package test;

import java.util.concurrent.TimeUnit;

import main.FrontController;

public class LogsPrinter implements Runnable {
	private final int tasksCount;
	private final FrontController facadeDispatcher;

	public LogsPrinter(int tasksCount, FrontController facadeDispatcher) {
		this.tasksCount = tasksCount;
		this.facadeDispatcher = facadeDispatcher;
	}

	@Override
	public void run() {
		for (int i = 0; i < tasksCount * 10; i++) {
			printLog();
		}

	}

	private void printLog() {
		String log = facadeDispatcher.getStringLog();
		if (!"no message.".equals(log)) {
			System.err.println(log);
		}
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
