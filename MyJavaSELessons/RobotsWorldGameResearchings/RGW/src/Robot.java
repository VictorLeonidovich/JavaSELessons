import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Robot implements Runnable {
	private final int ROBOT_QUANTITY = 10;
	private final int ID;
	private final String TYPE;
	private final Queue<String> LOG;
	private final List<Runnable> ROBOTS;

	public Robot(int id, String type) {
		this.ID = id;
		this.TYPE = type;
		this.LOG = new ConcurrentLinkedQueue<>();
		this.ROBOTS = new ArrayList<>();
		RobotFactory.createRobots(ROBOT_QUANTITY, "aborigen", ROBOTS);
	}

	public void onMessage() {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(Thread.currentThread().isInterrupted()){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if ("killYourself".equals("task")) {
				return;
			}else{
				LOG.add("task");
			}
		}

	}

}
