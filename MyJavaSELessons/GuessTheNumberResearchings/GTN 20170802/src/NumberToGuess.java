
public class NumberToGuess {
	private final int numberToGuess;
	private final int initialNumberOfRange;
	private final int endNumberOfRange;

	public NumberToGuess() {
		this(1, 9);
	}
	
	public NumberToGuess(int initialNumberOfRange, int endNumberOfRange) {
		this.initialNumberOfRange = initialNumberOfRange;
		this.endNumberOfRange = endNumberOfRange;
		numberToGuess = (int)(Math.random() * endNumberOfRange) + initialNumberOfRange;
	}
	
	public boolean isEqual(int checkedNumber){
		if (numberToGuess == checkedNumber) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getNumbersRangeValue(){
		return endNumberOfRange - initialNumberOfRange;
	}
	

}
