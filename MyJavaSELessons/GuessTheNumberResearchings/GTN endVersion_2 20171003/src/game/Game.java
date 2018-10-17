package game;

import javax.print.attribute.standard.Media;

import classes.Messages;
import interfaces.Printable;

public class Game {
	private NumberToGuess numberToGuess;
	private EnteredNumber enteredNumber;
	private Attempt attempt;
	private Printable printingObject;
	private boolean isNew;

	public Game() {
		this(new NumberToGuess(), new EnteredNumber(), new Attempt(), new ConsolePrinting());
	}

	public Game(NumberToGuess numberToGuess, EnteredNumber enteredNumber, Attempt attempt, Printable printingObject) {
		this.numberToGuess = numberToGuess;
		this.enteredNumber = enteredNumber;
		this.attempt = attempt;
		this.printingObject = printingObject;
		this.isNew = true;
	}

	public void play() {
		if (isNew) {
			printingObject.print(Messages.WELCOME_MESSAGE);
			
			isNew = false;
		}

	}

	private void initialize() {
		enteredNumber = new EnteredNumber();
		attempt = new Attempt();
		printingObject = new ConsolePrinting();
	}
}
