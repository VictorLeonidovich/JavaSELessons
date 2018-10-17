package gtn.readerapinew;

public class ObjectToReadConfiguration {
	private ObjectToRead objectToRead;

	public ObjectToReadConfiguration() {
		this(ObjectToRead.RANGE_OF_NUMBERS);
	}
	public ObjectToReadConfiguration(ObjectToRead objectToRead) {
		this.objectToRead = objectToRead;
	}
	public ObjectToRead getObjectToRead() {
		return objectToRead;
	}
	public void setObjectToRead(ObjectToRead objectToRead) {
		this.objectToRead = objectToRead;
	}
	
	
	

}
