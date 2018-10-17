package gtn.readerapinew;

import java.util.ArrayList;

public class ReaderFacadeImpl implements IReaderFacade {
	private ObjectToReadConfiguration objectToReadConfiguration;

	public ReaderFacadeImpl() {
		this(new ObjectToReadConfiguration());
	}

	public ReaderFacadeImpl(ObjectToReadConfiguration objectToReadConfiguration) {
		this.objectToReadConfiguration = objectToReadConfiguration;
	}

	@Override
	public ArrayList<?> readListOfObjects() {
		objectToReadConfiguration.setObjectToRead(ObjectToRead.RANGE_OF_NUMBERS);
		return objectToReadConfiguration.getObjectToRead().getObjectToRead().getListOfObjects();
	}

}
