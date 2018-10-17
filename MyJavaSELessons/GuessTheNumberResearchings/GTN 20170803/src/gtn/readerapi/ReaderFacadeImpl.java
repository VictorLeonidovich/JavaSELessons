package gtn.readerapi;

import java.util.ArrayList;

import gtn.readerapinew.ReadingType;

public class ReaderFacadeImpl implements IReaderFacade {
	private ReaderConfigurationImpl readerConfiguration;
	
	public ReaderFacadeImpl() {
		this(new ReaderConfigurationImpl());
	}

	public ReaderFacadeImpl(ReaderConfigurationImpl readerConfiguration) {
		this.readerConfiguration = readerConfiguration;
	}

	@Override
	public RandomObjectImpl readRandomObject() {
		readerConfiguration.setReadingType(ReadingType.INT_NUMBER);
		readerConfiguration.setReadSource(ReadSource.DEFAULT);
		readAllObjects();
		
		return null;
	}

	@Override
	public ArrayList readAllObjects() {
		// TODO Auto-generated method stub
		return null;
	}

}
