package main.taskstorage;

public class StringFormatException extends Exception {
	public StringFormatException(String message) {
		super(message + " Please correct the mistake and try again.");
	}
}
