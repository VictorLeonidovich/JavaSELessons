package main;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

import main.logstorage.ILogStorage;
import main.logstorage.LogStorage;
import main.robotmanagement.RobotCreation;
import main.robotmanagement.RobotTypeValidation;
import main.robotmanagement.RobotsThreadsDistribution;
import main.robotmanagement.ThreadStarter;
import main.taskmanagement.TaskCreation;
import main.taskmanagement.TaskDistribution;
import main.taskmanagement.TaskValidation;

public class GameConfiguration {
	private final FrontController frontController;
	private final GameController gameController;
	private final ILogStorage logsStorage;
	private final TaskValidation taskValidation;
	private final TaskCreation taskCreation;
	private final TaskDistribution taskDistribution;
	private final List<Robot> robots;
	private final List<Thread> robotsThreadsStorage;
	//private final RobotsFactory robotsFactory;
	
	private final RobotsThreadsDistribution robotsThreadsDistribution;
	private final ThreadStarter threadStarter;
	private final RobotCreation robotCreation;
	private final RobotTypeValidation robotTypeValidation;
	private final ActivityTracker activityTracker;
	
	public GameConfiguration(FrontController frontController) {
		this.frontController = frontController;
		this.logsStorage = new LogStorage(new ConcurrentLinkedDeque<>());//TODO make field new ConcurrentLinkedDeque<>()
		this.robots = new CopyOnWriteArrayList<Robot>();
		//this.robotsFactory = new RobotsFactory(this.robots);
		this.taskDistribution = new TaskDistribution(this.robots);
		this.taskCreation = new TaskCreation(this.taskDistribution);
		this.taskValidation = new TaskValidation(this.taskCreation);
		
		
		this.robotsThreadsStorage = new CopyOnWriteArrayList<>();
		
		this.robotsThreadsDistribution = new RobotsThreadsDistribution(robotsThreadsStorage);
		this.threadStarter = new ThreadStarter(robotsThreadsDistribution);
		this.robotCreation = new RobotCreation(robots, logsStorage, threadStarter);
		this.robotTypeValidation = new RobotTypeValidation(robotCreation);
		
		this.activityTracker = new ActivityTracker(robotsThreadsStorage, /*robotsFactory,*/ logsStorage, robotCreation, threadStarter, robotsThreadsDistribution);
		
		
		this.gameController = new GameController(this.logsStorage, this.taskValidation, /*this.robotsFactory,*/ this.robotTypeValidation, this.activityTracker);
		this.frontController.setGameController(gameController);
		
		
	}

	
}
