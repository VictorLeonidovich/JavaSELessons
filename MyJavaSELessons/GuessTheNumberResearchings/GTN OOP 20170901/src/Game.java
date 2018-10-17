
public class Game implements Configurable, Playable, Exitable {
	private Attempt attempt;
	private NumberToGuess numberToGuess;
	private EnteredNumber enteredNumber;
	
	@Override
	public void configure() {
		attempt = new Attempt();
		numberToGuess = new NumberToGuess();
		enteredNumber = new EnteredNumber();

	}

	@Override
	public void play() {
		try {
			if (enteredNumber.isEqual(numberToGuess)) {
				//winner
			}//else --- looser
		} catch (NotInitializationException e) {
			//throw new NotInitializationException();
			//e.printStackTrace();
		}

	}

	@Override
	public void exit() {
		attempt = null;
		numberToGuess = null;
		enteredNumber = null;
	}

}
