package tips.patterns.delegation.complexdelegation;

/*information from site:
 * ru.wikipedia.org*/

/*интерфейс описывает действие, которое будет вызываться при наступлении
 * события от таймера*/

public interface TimerAction {
	void onTime();

}
