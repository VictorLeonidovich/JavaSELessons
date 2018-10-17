package gtn.readerapi;


import java.util.Map;

public class RandomObjectImpl<T> implements IRandomObjectGenerable<T> {
	private int randomObject;
	private final int initialRandomObjectRange;
	private final int endRandomObjectRange;
	private Map<Integer, T> objectsInRange;

	public RandomObjectImpl() {
		this(1, 9);
	}
	
	public RandomObjectImpl(int initialRandomObjectRange, int endRandomObjectRange) {
		this.initialRandomObjectRange = initialRandomObjectRange;
		this.endRandomObjectRange = endRandomObjectRange;
	}
	
	public boolean isEqual(int checkedNumber){
		if (randomObject == checkedNumber) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getRandomObjectRangeValue(){
		return endRandomObjectRange - initialRandomObjectRange;
	}

	@Override
	public RandomObjectImpl<T> generateRandomObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
