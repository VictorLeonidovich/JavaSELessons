package gtn.readerapinew;

import java.util.ArrayList;

public class RangeOfNumbers implements IListOfObjectsGettable {
	private Integer range;
	private ArrayList<Integer> listOfObjects;
	
	
	public RangeOfNumbers() {
		this(9);
	}

	public RangeOfNumbers(Integer range) {
		this.range = range;
		generateListOfObjects();
	}
	
	private void generateListOfObjects(){
		for (int i = 1; i < range; i++) {
			listOfObjects.add(i);
		}
		
	}
	@Override
	public ArrayList<Integer> getListOfObjects() {
		
		return listOfObjects;
	}


}
