package gtn.readerapi;

import gtn.readerapinew.ReadingType;

public class ReaderConfigurationImpl implements IReaderConfiguration {
	private ReadingType readingType;
	private ReadSource readSource;

	public ReaderConfigurationImpl() {
		this(ReadingType.INT_NUMBER, ReadSource.CONSOLE);
	}

	public ReaderConfigurationImpl(ReadingType readingType, ReadSource readSource) {
		this.readingType = readingType;
		this.readSource = readSource;
	}

	@Override
	public void setReadingType(ReadingType readingType) {
		this.readingType = readingType;
	}

	@Override
	public void setReadSource(ReadSource readSource) {
		this.readSource = readSource;
	}
	
	

}
