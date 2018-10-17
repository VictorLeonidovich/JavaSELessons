package gtn.managed;

public class NumberToGuess implements Initializable, Equalable {
	private Integer numberToGuess;

	@Override
	public void initialize() {
		this.numberToGuess = (int)(Math.random() * 9) + 1;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numberToGuess == null) ? 0 : numberToGuess.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumberToGuess other = (NumberToGuess) obj;
		if (numberToGuess == null) {
			if (other.numberToGuess != null)
				return false;
		} else if (!numberToGuess.equals(other.numberToGuess))
			return false;
		return true;
	}


	@Override
	public boolean isEqual(Equalable object) {
		return this.equals(object);
	}
	

}
