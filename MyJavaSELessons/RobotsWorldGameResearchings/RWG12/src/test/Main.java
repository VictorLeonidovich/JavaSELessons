package test;

import java.util.concurrent.TimeUnit;

import main.FrontController;

public class Main {

	public static void main(String[] args) {
		FrontController frontController = new FrontController();
		int tasksCount = 50;
		LogsPrinter logsPrinter = new LogsPrinter(tasksCount + 20, frontController);
		Thread logsPrinterThread = new Thread(logsPrinter);
		logsPrinterThread.start();
		//test has no robots
		/*try {
			System.out.println("pause 2 seconds");
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		RobotGenerator robotGenerator = new RobotGenerator(frontController);
		Thread robotGeneratorThread = new Thread(robotGenerator);
		robotGeneratorThread.start();
		TaskGenerator tasksGenerator = new TaskGenerator(tasksCount, frontController/*, robotGenerator*/);
		Thread taskGeneratorThread = new Thread(tasksGenerator);
		taskGeneratorThread.start();
		
		
		try {
			TimeUnit.SECONDS.sleep(15);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
