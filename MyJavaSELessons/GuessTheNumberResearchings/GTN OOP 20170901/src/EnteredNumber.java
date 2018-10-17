
public class EnteredNumber implements Equalable  {
	private Integer enteredNumber;

	@Override
	public boolean isEqual(Equalable object) throws NotInitializationException {
		if (enteredNumber == null) {
			throw new NotInitializationException();
		}
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enteredNumber == null) ? 0 : enteredNumber.hashCode());
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
		EnteredNumber other = (EnteredNumber) obj;
		if (enteredNumber == null) {
			if (other.enteredNumber != null)
				return false;
		} else if (!enteredNumber.equals(other.enteredNumber))
			return false;
		return true;
	}
	

}
