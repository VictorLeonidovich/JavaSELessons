package chain;

public class Messages {
	public final static String WELCOME_MESSAGE =
			"Добро пожаловать в игру \"Угадай цифру\".\n" 
			+ "Разработчик – Виктор Красиков.\n"
			+ "Угадайте цифру от 1 до 9 включительно. У Вас есть всего три попытки.";
	public final static String ATTEMPT_LEFT_MESSAGE = 
			"Попытка № " + /*ATTEMPT + */".";
	public final static String ENTER_NUMBER_IN_RANGE_MESSAGE = 
			"Введите цифру от 1 до 9:";
	public final static String PLEASE_ENTER_NUMBER_IN_RANGE_MESSAGE = 
			"Введите, пожалуйста, цифру от 1 до 9!!!";
	public final static String YOU_ARE_WINNER_FROM_ATTEMPT_MESSAGE = 
			"Вы победили! Угадали с " + /*ATTEMPT + */" попытки цифру " +
			/*ENTERED NUMBER + */".";
	public final static String DO_YOU_WANT_TO_PLAY_YET_MESSAGE = 
			"Хотите ли сыграть ещё?";
	public final static String NUMBER_IS_SMALLER_OR_LAGER_MESSAGE = 
			"Введенная Вами цифра " + /*МЕНЬШЕ(БОЛЬШЕ) + */" искомой цифры.";
	public final static String TRY_AGAIN_MESSAGE = 
			"Попробуйте еще раз.";
	public final static String YOU_DIDNT_HAVE_ANY_ATTEMPT_YOU_LOST_MESSAGE = 
			"У Вас закончились три попытки. К сожалению, Вы ПРОИГРАЛИ(((";
	public final static String GUESSED_NUMBER_WAS_MESSAGE = 
			"Отгадываемая цифра была " + /*numbertoguess + */".";
}
