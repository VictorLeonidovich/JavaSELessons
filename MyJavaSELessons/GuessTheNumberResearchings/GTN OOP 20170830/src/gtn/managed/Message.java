package gtn.managed;

public class Message implements Printable{
	private String message;

	@Override
	public void print() {
		System.out.println(message);
	}
	

}
