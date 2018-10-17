package classes;

public class ServerResource {

	private Integer intNumber;

	private void initializeIntNumber() {
		// TODO Auto-generated method stub
		intNumber = createNumber();
	}

	public Integer getIntNumber() {
		if (intNumber == null) {
			initializeIntNumber();
		}
		return intNumber;
	}

}
