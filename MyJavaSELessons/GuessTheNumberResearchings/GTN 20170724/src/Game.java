
public class Game {

	private Game game;

	public void startGame(Game newGame) {
		game = newGame;
		//game.gameLogic.startGame(game);
		consolePrinterObject.print(messageManagerObject.createWelcomeAndDescriptionMessage());
	}


	private Attempt attemptObject;

	public void setAttemptObject(Attempt attemptObject) {
		this.attemptObject = attemptObject;
	}

	public StringBuffer createMessageAboutNumberOfAttempt(StringBuffer stringBuffer) {
		return attemptObject.createMessageAboutNumberOfAttempt(stringBuffer);
	}

	private NumberToGuess numberToGuessObject;

	public void setNumberToGuessObject(NumberToGuess numberToGuessObject) {
		this.numberToGuessObject = numberToGuessObject;
	}

	/*
	 * public int getNumberToGuess() { return
	 * numberToGuessObject.getNumberToGuess(); }
	 */

	private boolean winner;

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	private MessageManager messageManagerObject;

	public void setMessageManagerObject(MessageManager messageManagerObject) {
		this.messageManagerObject = messageManagerObject;
	}

	public void printMessage(TextMessage textMessage) {
		String message = messageManagerObject.getMessage(textMessage, getGame());
		consolePrinterObject.print(message);
	}

	private GameLogic gameLogic;

	public void setGameLogic(GameLogic gameLogic) {
		this.gameLogic = gameLogic;
	}

	private ConsolePrinter consolePrinterObject;

	public void setConsolePrinterObject(ConsolePrinter consolePrinterObject) {
		this.consolePrinterObject = consolePrinterObject;
	}

	private ConsoleReader ConsoleReaderObject;

	public void setConsoleReaderObject(ConsoleReader consoleReaderObject) {
		ConsoleReaderObject = consoleReaderObject;
	}

	public int readNextNumber() {

		return ConsoleReaderObject.readFromConsole();
	}

	private EnteredNumber enteredNumberObject;

	public void setEnteredNumberObject(EnteredNumber enteredNumberObject) {
		this.enteredNumberObject = enteredNumberObject;
	}

	public void checkNumber() {
		// TODO Auto-generated method stub
		if (numberToGuessObject.isEqual(readNextNumber())) {
			messageManagerObject.getMessage(TextMessage.CONGRATULATION_YOU_ARE_WINNER, game);
			messageManagerObject.getMessage(TextMessage.YOU_ARE_GUESS_THE_NUMBER_XXX_BY_XXX_ATTEMPTS, game);
		} else {
			if (attemptObject.hasNextAttempt()) {
				readNextNumber();
			} else {
				messageManagerObject.getMessage(TextMessage.ATTEMPTS_ENDED_UNFORTUNATELY_YOU_LOST, game);
			}

		}
		;

	}

	public Game() {
		setNumberToGuessObject(new NumberToGuess());
		setWinner(false);
		setMessageManagerObject(new MessageManager());
		setGameLogic(new GameLogic());
		setAttemptObject(new Attempt(1, 3));
		setConsolePrinterObject(new ConsolePrinter());
		setConsoleReaderObject(new ConsoleReader());

	}

}
