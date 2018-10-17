
public enum TextMessage {
	
	CONGRATULATION_YOU_ARE_WINNER("Поздравляем! Вы победили!"),
	WELCOME_TO_GTN_GAME("Добро пожаловать в игру \"Угадай цифру\"."),
	PLEASE_ENTER_THE_NUMBER_FROM_1_TO_9("Введите, пожалуйста, цифру от 1 до 9:"),
	PLEASE_ENTER_THE_NUMBER_NOT_SIMBOL("Введите, пожалуйста, ЦИФРУ, а не букву или символ"),
	DEVELOPER_VICTOR_KRASIKOV("Разработчик - Виктор Красиков."),
	GUESS_THE_NUMBER_FROM_1_TO_9_INCLUDED__YOU_HAVE_ONLY_3_ATTEMPTS("Угадайте цифру от 1 до 9 включительно. У Вас есть всего три попытки."),
	ATTEMPT_NUMBER_("Попытка № ");
	
	private String message;
	
	TextMessage() {}

	TextMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
	
	
	
	

}
