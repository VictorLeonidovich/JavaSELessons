package tips.patterns.delegation.complexdelegation;

import java.util.Scanner;

/*information from site:
 * ru.wikipedia.org*/

/*����� �������. ��� ������������ �������� ���������� �������� TimerAction*/

public class Timer {
	TimerAction action;

	/* �������, ������� �������� ����������� ��� ��������� �������. */

	void run() {
		if (isTime()) {
			action.onTime();
		}
	}

	/*
	 * ��������� �������, ������� ����� �� ���� ��� ������ �� ��������. Ÿ
	 * ���������� �� ��������� � ������ ���������.
	 */
	private boolean isTime() {
		return true;
	}
	public static void main(String[] args){
		System.out.println("������� ��� ��������:");
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


