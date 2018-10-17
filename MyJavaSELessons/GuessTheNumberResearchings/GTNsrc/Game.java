
public class Game {
	
	private int attempt;
	
	public int getAttempt() {
		return attempt;
	}

	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}

	private NumberToGuess numberToGuess;

	public int getNumberToGuess() {
		return numberToGuess.getNumber();
	}

	private void setNumberToGuess(NumberToGuess numberToGuess) {
		this.numberToGuess = numberToGuess;
	}

	private Winner winner;

	public boolean isWinner() {
		return winner.isWinner();
	}

	private void setWinner(Winner winner) {
		this.winner = winner;
	}

	private TextMessage message;

	public String getMessage() {
		return message.getMessage();
	}
	
	private void setMessage(Class<TextMessage> class1) {
		try {
			message = class1.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private GameLogic gameLogic;
	
	public GameLogic getGameLogic() {
		return gameLogic;
	}

	public void setGameLogic(GameLogic gameLogic) {
		this.gameLogic = gameLogic;
	}

	private ConsoleReader enteredNumber;
	
	

	public Game() {
		setNumberToGuess(new NumberToGuess());
		setWinner(new Winner());
		setMessage(TextMessage.class);
		setGameLogic(new GameLogic());
		
		// ConsoleReader
		
		
	}

	

	public static Game getGame() {
		return new Game();
	}

}
