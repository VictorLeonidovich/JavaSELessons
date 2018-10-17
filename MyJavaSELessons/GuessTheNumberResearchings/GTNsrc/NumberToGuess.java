
public class NumberToGuess {
	private final int number;

	public int getNumber() {
		return number;
	}

	public NumberToGuess() {
		number = (int)(Math.random() * 9) + 1;
	}
	
	

}
