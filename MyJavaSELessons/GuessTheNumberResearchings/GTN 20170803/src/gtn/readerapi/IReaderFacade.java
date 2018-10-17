package gtn.readerapi;

import java.util.ArrayList;

public interface IReaderFacade<T> {
	public RandomObjectImpl<T> readRandomObject();
	public ArrayList<T> readAllObjects();

}
