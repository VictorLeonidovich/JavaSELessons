import java.util.List;

public class ActivityDispatcher implements Runnable {
	private final List<Runnable> ROBOTS;

	public ActivityDispatcher(List<Runnable> robots) {
		this.ROBOTS = robots;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			checkRobots();
		}
	}

	private void checkRobots() {
		for (int i = 0; i < ROBOTS.size(); i++) {
			
		}
		
	}

}
