package gtn.randomobjectgeneratorapi;

import java.util.ArrayList;

public interface IRandomObjectGenerable<T> {
	public T generateRandomObject(ArrayList<T> listOfObjects);

}
