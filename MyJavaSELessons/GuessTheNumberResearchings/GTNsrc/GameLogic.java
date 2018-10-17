
public class GameLogic {
	
	public void startGame(Game newGame){
		if (newGame == null) {
			System.err.println("Игра не может быть начата. Ошибка нулевого объекта.");
			return;
		}
		ConsolePrinter.print(TextMessage.WELCOME_TO_GTN_GAME.getMessage());
		ConsolePrinter.print(TextMessage.DEVELOPER_VICTOR_KRASIKOV.getMessage());
		ConsolePrinter.print(TextMessage.GUESS_THE_NUMBER_FROM_1_TO_9_INCLUDED__YOU_HAVE_ONLY_3_ATTEMPTS.getMessage());
		ConsolePrinter.print(TextMessage.ATTEMPT_NUMBER_.getMessage());
		ConsolePrinter.print(TextMessage.PLEASE_ENTER_THE_NUMBER_FROM_1_TO_9.getMessage());
		ConsoleReader.readFromConsole();
	}

}
