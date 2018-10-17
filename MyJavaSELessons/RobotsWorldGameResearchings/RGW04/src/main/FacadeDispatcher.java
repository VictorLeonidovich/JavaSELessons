package main;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class FacadeDispatcher implements IRobotsgameWorld {
	private volatile Deque<Task> tasksStorage = new ConcurrentLinkedDeque<>();
	private volatile Deque<String> logsStorage = new ConcurrentLinkedDeque<>();
	private final List<Thread> robotsStorage = new ArrayList<>();
	private final ActivityTracker activityTracker = new ActivityTracker(tasksStorage, logsStorage, robotsStorage);
	
	@Override
	public synchronized void addStringTask(String stringTask) {
		activityTracker.notifyAboutAppearedTask(stringTask);
	}

	@Override
	public String getStringLog() {
		String log = logsStorage.pollLast();
		if (log == null) {
			log = "no message.";
		}
		return log;
	}

}
