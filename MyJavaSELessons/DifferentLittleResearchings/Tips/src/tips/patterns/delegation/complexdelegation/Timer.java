package tips.patterns.delegation.complexdelegation;

import java.util.Scanner;

/*information from site:
 * ru.wikipedia.org*/

/*Класс таймера. При определенных условиях вызывается действие TimerAction*/

public class Timer {
	TimerAction action;

	/* Функция, которую вызывает программист для установки времени. */

	void run() {
		if (isTime()) {
			action.onTime();
		}
	}

	/*
	 * Некоторая функция, которая берет на себя всю работу со временем. Её
	 * реализация не интересна в данном контексте.
	 */
	private boolean isTime() {
		return true;
	}
	public static void main(String[] args){
		System.out.println("Введите тип действия:");
		Scanner scanner = new Scanner(System.in);
		String actionType = scanner.nextLine();
		Timer timer = new Timer();
		
		if (actionType.equalsIgnoreCase("set wake up timer")) {
			timer.action = new WakeUpAction();			
		} else if (actionType.equalsIgnoreCase("set chicken timer")) {
			timer.action = new ChickenIsReadyAction();
		}
		
		timer.run();
		scanner.close();
	}
	
	
}


