package gtn.readerapi;

import java.util.ArrayList;
import java.util.Map;

public class DefaultIntNumberReader<T> implements IObjectReader<T>{
	
	private T count;
	private final Integer initialIntNumberRange;
	private final Integer endIntNumberRange;
	private ArrayList<T> list = new ArrayList<>();
	
	public DefaultIntNumberReader() {
		this(1, 9);
	}
	
	public DefaultIntNumberReader(Integer initialIntNumberRange, Integer endIntNumberRange) {
		this.initialIntNumberRange = initialIntNumberRange;
		this.endIntNumberRange = endIntNumberRange;
	}

	@Override
	public ArrayList<Integer> readObjects() {
		count = initialIntNumberRange;
		list.add(count);
		count = count + 1;
		
		if (count < endIntNumberRange) {
			readObjects();
		} 
		return list;
	}

}
