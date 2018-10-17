package gtn.readerapinew;

import java.util.ArrayList;

public class Alphabet implements IListOfObjectsGettable {
	private Integer range;
	private ArrayList<Character> listOfObjects;
	
	
	public Alphabet() {
		this(26);
	}

	public Alphabet(Integer range) {
		this.range = range;
		generateListOfObjects();
	}
	
	private void generateListOfObjects(){
		for (int i = 65; i < 65 + range; i++) {
			listOfObjects.add((char)i);
		}
		
	}
	@Override
	public ArrayList<Character> getListOfObjects() {
		return listOfObjects;
	}

}
