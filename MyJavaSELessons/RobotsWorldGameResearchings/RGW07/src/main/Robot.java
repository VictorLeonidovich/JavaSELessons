package main;

import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Robot implements Runnable {
	private volatile Deque<String> logsStorage;
	private final ThreadLocal<Long> id;
	private final ThreadLocal<RobotType> robotType;
	private final ThreadLocal<Boolean> isAlive;
	private Log LOG = LogFactory.getLog(Robot.class);

	public Robot(final long id, RobotType robotType, Deque<String> logsStorage) {
		this.logsStorage = logsStorage;
		this.id = new ThreadLocal<Long>() {
			@Override
			protected Long initialValue() {
				return id;
			}
		};
		this.robotType = new ThreadLocal<RobotType>() {
			@Override
			protected RobotType initialValue() {
				return robotType;
			}
		};
		this.isAlive = new ThreadLocal<Boolean>() {
			@Override
			protected Boolean initialValue() {
				return false;
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

	public void doTask() {
		long startTime = System.currentTimeMillis();
		Task task = this.robotType.get().pollTask();
		int restTasks = this.robotType.get().getSize(); // TODO taskAmount
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
				logsStorage.addFirst(
						this.toString() + " have been done the Task [" + task.toString() + "] (KILLYOURSELF) successfully. Time: "
								+ (System.currentTimeMillis() - startTime) + " ms. Rest Tasks: " + restTasks);
			} else {
				logsStorage.addFirst(
						this.toString() + " have been done the Task [" + task.toString() + "] successfully. Time: "
								+ (System.currentTimeMillis() - startTime) + " ms. Rest Tasks: " + restTasks);
			}
		}
	}

	private long getTimeOut(Task task) { // TODO getTimeOutCoefficient
		long timeout;
		//TODO if task != null or parameters
		if (this.robotType.get().isNativeMission(task.getMission())) {
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
			doTask();
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
		return "Robot [id=" + id.get() + ", robotType=" + robotType.get() + "]";
	}

	public long getId() {
		return this.id.get();
	}

}
