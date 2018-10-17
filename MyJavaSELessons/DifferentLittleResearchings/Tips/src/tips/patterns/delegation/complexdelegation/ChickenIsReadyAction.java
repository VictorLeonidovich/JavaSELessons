package tips.patterns.delegation.complexdelegation;

/*information from site:
 * ru.wikipedia.org*/

public class ChickenIsReadyAction implements TimerAction {

	@Override
	public void onTime() {
		System.out.println("Цыпленок готов!");
		
	}

}
