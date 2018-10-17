package main;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Logs implements Runnable {
	private final ObjectsFactory objectsFactory;
	private final Queue<Log> logs;

	public Logs(ObjectsFactory objectsFactory, Queue<Log> logs) {
		this.objectsFactory = objectsFactory;
		this.logs = logs;
	}

	public synchronized boolean addLog(String message, Date date) {
		logs.add(createLog(message, date));
		return true;
	}

	private Log createLog(String message, Date date) {
		return objectsFactory.createLog(message, date);
	}

	private void printLogs() {
		System.out.println("Print logs: " + this.logs.poll().toString());
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			if (!logs.isEmpty()) {
				printLogs();
			}
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
