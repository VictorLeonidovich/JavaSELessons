
public class MessageManager {

	private StringBuffer getStringBuffer() {
		return new StringBuffer();
	}

	public String createWelcomeAndDescriptionMessage() {
		return "createWelcomeAndDescriptionMessage()";
	}
	
public void createEnterNumberMessage() {

	}

	public void createWinnerMessage() {

	}

	public void createLooserMessage() {

	}

	public void createNextAttemptMessage() {

	}
	
	
	public String getMessage(TextMessage textMessage, Game game) {
		// System.out.println("...MessageManager");

		switch (textMessage) {
		case WELCOME_TO_GTN_GAME:
			return "Добро пожаловать в игру \"Угадай цифру\".";
		case DEVELOPER_VICTOR_KRASIKOV:
			return "Разработчик - Виктор Красиков.";
		case GUESS_THE_NUMBER_FROM_1_TO_9_INCLUDED__YOU_HAVE_ONLY_3_ATTEMPTS:
			return "Угадайте цифру от 1 до 9 включительно. У Вас есть всего три попытки.";
		case ATTEMPT_NUMBER_:
			return (game.createMessageAboutNumberOfAttempt(getStringBuffer().append("Попытка № "))).append(".")
					.toString();
		case PLEASE_ENTER_THE_NUMBER_FROM_1_TO_9:
			return "Введите, пожалуйста, цифру от 1 до 9:";
		default:
			return "произошла ошибка в классе MessageManager";
		}

	}

}
