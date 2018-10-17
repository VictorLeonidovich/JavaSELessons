package gtn.randomobjectgeneratorapi;

import java.util.ArrayList;

public class RandomObjectGenerableImpl<T> implements IRandomObjectGenerable<T> {
	private T randomObject;
	
	@Override
	public T generateRandomObject(ArrayList<T> listOfObjects) {
		int randomObjectIndex = (int)(Math.random() * listOfObjects.size());
		randomObject = listOfObjects.get(randomObjectIndex);
		return randomObject;
	}

}
