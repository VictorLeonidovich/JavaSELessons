package test.taskstorage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.RealTask;
import main.RobotTypeUtils;
import main.taskstorage.NoTaskException;
import main.taskstorage.StringFormatException;
import main.taskstorage.TaskStorageConfiguration;
import main.taskstorage.TaskStorageFrontControl;

public class TaskStorageFrontControlTest {
	private TaskStorageConfiguration taskStorageConfiguration;
	private TaskStorageFrontControl taskStorageFrontControl;

	@Before
	public void setUp() throws Exception {
		taskStorageConfiguration = new TaskStorageConfiguration();
		taskStorageFrontControl = taskStorageConfiguration.getTaskStorageFrontControl();
		taskStorageFrontControl.addTaskByStringMission("1:1:destroy");
		taskStorageFrontControl.addTaskByStringMission("1:destroyer:destroy");
		taskStorageFrontControl.addTaskByStringMission("1:1,destroyer:destroy");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddTaskByStringMission() {
		try {
			taskStorageFrontControl.addTaskByStringMission("2:2:build");
			taskStorageFrontControl.addTaskByStringMission("2:builder:build");
		} catch (StringFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetTaskByRobotId() {
		try {
			assertSame(RealTask.DESTROY, taskStorageFrontControl.getTaskByRobotId(1));
			// System.out.println(taskStorageFrontControl.getTaskByRobotId(1));
		} catch (NoTaskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetTaskByRobotType() {
		try {
			assertSame(RealTask.DESTROY, taskStorageFrontControl.getTaskByRobotType(RobotTypeUtils.DESTROYER));
			// System.out.println(taskStorageFrontControl.getTaskByRobotType(RobotTypeUtils.DESTROYER));
		} catch (NoTaskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
