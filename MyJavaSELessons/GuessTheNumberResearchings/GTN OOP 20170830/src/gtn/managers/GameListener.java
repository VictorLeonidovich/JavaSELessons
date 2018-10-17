package gtn.managers;

import gtn.managed.Incrementable;
import gtn.managed.Initializable;
import gtn.managed.Inputable;
import gtn.managed.Printable;

public class GameListener {
	private Incrementation incrementationObject;
	private Initialization intializationObject;
	private Printing printingObject;
	private Inputing inputingObject;

	public GameListener() {
		this(new Incrementation(), new Initialization(), new Printing(), new Inputing());
	}

	public GameListener(Incrementation incrementationObject, Initialization intializationObject,
			Printing printingObject, Inputing inputingObject) {
		super();
		this.incrementationObject = incrementationObject;
		this.intializationObject = intializationObject;
		this.printingObject = printingObject;
		this.inputingObject = inputingObject;
	}

	public void increment(Incrementable object) {
		incrementationObject.increment(object);
		// TODO
	}

	public void initialize(Initializable object) {
		intializationObject.initialize(object);
		// TODO
	}

	public void input(Inputable object) {
		inputingObject.input(object);
		// TODO
	}

	public void print(Printable object) {
		printingObject.print(object);
		// TODO
	}
}
