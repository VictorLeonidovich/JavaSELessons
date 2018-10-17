package tips.patterns.delegation.complexdelegation;

/*information from site:
 * ru.wikipedia.org*/

public class WakeUpAction implements TimerAction {

	@Override
	public void onTime() {
		System.out.println("Пора вставать!");
		
	}

}
