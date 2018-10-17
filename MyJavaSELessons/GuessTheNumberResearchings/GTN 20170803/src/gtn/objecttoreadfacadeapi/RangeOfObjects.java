package gtn.objecttoreadfacadeapi;
//TODO
import java.util.ArrayList;

import gtn.randomobjectgeneratorapi.RandomObjectGenerableImpl;

public class RangeOfObjects<T> {
	private T randomObject;
	private ArrayList<T> listOfObjects;
	private RandomObjectGenerableImpl<T> randomObjectGenerableImpl;

	public RangeOfObjects(T randomObject) {
		this.randomObject = randomObject;
		randomObjectGenerableImpl = new RandomObjectGenerableImpl<T>();
		generateListOfObjects();
	}
	
	private void generateListOfObjects(){
		randomObject = randomObjectGenerableImpl.generateRandomObject(listOfObjects);
		
	}
	public ArrayList<T> getListOfObjects() {
		// TODO Auto-generated method stub
		return listOfObjects;
	}
	
	public boolean isEqual(T enteredNumber){
		boolean isEqual = false;
		if(randomObject.equals(enteredNumber)){isEqual = true;}
		return isEqual;
		
	}

}
