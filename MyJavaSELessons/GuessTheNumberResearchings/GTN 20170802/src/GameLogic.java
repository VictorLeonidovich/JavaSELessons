
public class GameLogic {
	
	public void startGame(Game newGame){
		if (newGame == null) {
			System.err.println("Игра не может быть начата. Ошибка нулевого объекта.");
			return;
		}
		//System.out.println("...GameLogic");
		newGame.printMessage(TextMessage.WELCOME_TO_GTN_GAME);
		newGame.printMessage(TextMessage.DEVELOPER_VICTOR_KRASIKOV);
		newGame.printMessage(TextMessage.GUESS_THE_NUMBER_FROM_1_TO_9_INCLUDED__YOU_HAVE_ONLY_3_ATTEMPTS);
		newGame.printMessage(TextMessage.ATTEMPT_NUMBER_);
		newGame.printMessage(TextMessage.PLEASE_ENTER_THE_NUMBER_FROM_1_TO_9);
		
		newGame.readNextNumber();
		newGame.checkNumber();
	}

}
