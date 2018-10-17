package main;

import java.util.Deque;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Robot implements Runnable {
	private volatile Deque<String> logsStorage;
	private final ThreadLocal<Long> id;
	private final ThreadLocal<RobotTypeUtils> robotTypeUtils;
	private final ThreadLocal<Boolean> isAlive;
	private final ThreadLocal<Deque<Task>> personalTaskStorage;
	private Log LOG = LogFactory.getLog(Robot.class);

	public Robot(final long id, RobotTypeUtils robotTypeUtils, Deque<String> logsStorage, Deque<Task> personalTaskStorage) {
		this.logsStorage = logsStorage;
		this.id = new ThreadLocal<Long>() {
			@Override
			protected Long initialValue() {
				return id;
			}
		};
		this.robotTypeUtils = new ThreadLocal<RobotTypeUtils>() {
			@Override
			protected RobotTypeUtils initialValue() {
				return robotTypeUtils;
			}
		};
		this.isAlive = new ThreadLocal<Boolean>() {
			@Override
			protected Boolean initialValue() {
				return false;
			}
		};
		this.personalTaskStorage = new ThreadLocal<Deque<Task>>() {
			@Override
			protected Deque<Task> initialValue() {
				return personalTaskStorage;// TODO simple deque
			}
		};

		logsStorage.addFirst(this.toString() + " was created."); // TODO and
																	// started

	}

	public void killRobot() {
		isAlive.set(false);
	}

	public void aliveRobot() {
		isAlive.set(true);
	}

	public void doTask(Task task) {
		long startTime = System.currentTimeMillis();
		int restTasks = this.robotTypeUtils.get().getSize(); // TODO taskAmount
		if (task != null) {
			try {
				TimeUnit.MILLISECONDS.sleep(getTimeOut(task));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (Mission.KILLYOURSELF.toString().toLowerCase().equals(task.getMission())) {
				LOG.debug(this.toString() + " was died!!!");
				isAlive.set(false);
				logsStorage.addFirst(this.toString() + " have been done the Task [" + task.toString()
						+ "] (KILLYOURSELF) successfully. Time: " + (System.currentTimeMillis() - startTime)
						+ " ms. Rest Common Tasks: " + restTasks + ". Rest personal tasks: " + personalTaskStorage.get().size());
			} else {
				logsStorage.addFirst(
						this.toString() + " have been done the Task [" + task.toString() + "] successfully. Time: "
								+ (System.currentTimeMillis() - startTime) + " ms. Rest Common Tasks: " + restTasks + ". Rest personal tasks: " + personalTaskStorage.get().size());
			}
		}
	}

	private long getTimeOut(Task task) { // TODO getTimeOutCoefficient
		long timeout;
		// TODO if task != null or parameters
		if (this.robotTypeUtils.get().isNativeMission(task.getMission())) {
			timeout = 100;
		} else if (task.getMission().equals(Mission.KILLYOURSELF.toString().toLowerCase())) {
			timeout = 500;
		} else {
			timeout = 300;
		}
		return timeout;
	}

	@Override
	public void run() {
		isAlive.set(true);
		while (isAlive.get()) {
			Task task = getTaskFromPersonalTaskStorage();
			if (task != null) {
				LOG.debug("!!!" + task + " getted from personal storage of " + this);
			}
			if (task == null) {
				task = this.robotTypeUtils.get().pollTask();
				doTask(task);
			} else {
				doTask(task);
			}

			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "Robot [id=" + id.get() + ", robotType=" + robotTypeUtils.get() + "]";
	}

	public long getId() {
		return this.id.get();
	}

	public void addTaskToPersonalTaskStorage(Task task) {
		personalTaskStorage.get().addFirst(task);
		LOG.debug(personalTaskStorage.get().peekLast() + " added to personal storage of " + this);
	}

	public Task getTaskFromPersonalTaskStorage() {
		return personalTaskStorage.get().pollLast();
	}
}
