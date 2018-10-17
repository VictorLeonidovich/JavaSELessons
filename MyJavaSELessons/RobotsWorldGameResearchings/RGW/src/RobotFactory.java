import java.util.List;

public class RobotFactory {

	public static void createRobots(int robotQuantity, String type, List<Runnable> robots) {
		for (int i = 0; i < robotQuantity; i++) {
			Robot myRobot = new MyRobot(robots.size(), type);
			Thread thread = new Thread(myRobot);
			thread.setDaemon(true);
			thread.start();
			robots.add(thread);
			};
		}
}
