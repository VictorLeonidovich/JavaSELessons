package gtn.managers;

import gtn.managed.Incrementable;

public class GameListener {
	private Incrementation incrementationObject;
	private Initialization intializationObject;
	
	

	public GameListener() {
		this(new Incrementation());
	}



	public GameListener(Incrementation incrementationObject) {
		this.incrementationObject = incrementationObject;
	}
	
	public void increment(Incrementable object){
		incrementationObject.increment(object);
		
	}
	
	
	

}
