
public class NumberToGuess implements Equalable {
	private Integer numberToGuess;

	@Override
	public boolean isEqual(Equalable object) throws NotInitializationException {
		if (numberToGuess == null) {
			throw new NotInitializationException();
		}
		return false;
		// TODO Auto-generated method stub
		
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
			throw new NotInitializationException();
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
	

}
