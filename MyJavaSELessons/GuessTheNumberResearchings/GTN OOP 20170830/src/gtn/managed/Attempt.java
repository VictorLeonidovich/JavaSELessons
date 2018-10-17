package gtn.managed;

public class Attempt implements Incrementable, Initializable {
	private Integer numberOfAttempt;

	@Override
	public void increment() {
		//hasNext
		numberOfAttempt = numberOfAttempt + 1;
		
	}

	@Override
	public void initialize() {
		numberOfAttempt = 1;
		
	}

}
