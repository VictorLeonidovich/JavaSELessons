package game;

import java.io.IOException;

import exceptions.NotBiggerException;
import exceptions.NotEqualsException;
import exceptions.NotInitializationException;
import exceptions.NotNextElementException;
import exceptions.NotSmallerException;
import exceptions.NotTrueFormatException;
import exceptions.OutOfRangeException;
import interfaces.Exitable;
import interfaces.Initializable;
import interfaces.Playable;
import interfaces.Printable;

public class Game implements Initializable, Playable, Exitable {
	private NumberToGuess numberToGuess;
	private EnteredNumber enteredNumber;
	private Attempt attempt;
	private Printable printableObject;

	@Override
	public void initialize() {
		numberToGuess = new NumberToGuess();
		enteredNumber = new EnteredNumber();
		attempt = new Attempt();
		printableObject = new ConsolePrinting();
	}

	@Override
	public void play() {
		if (numberToGuess == null || enteredNumber == null || attempt == null ||
				printableObject == null) {
			initialize();
		}

		try {
			if (enteredNumber.isEquals(numberToGuess)) {
				// TODO "�� ��������! ������� � " + /*ATTEMPT + */" �������
				// ����� " +
				/// *ENTERED NUMBER + */".";
				// "������ �� ������� ���?"
				printableObject.print(Messages.YOU_ARE_WINNER_FROM_ATTEMPT_MESSAGE);
			}
		} catch (NotEqualsException e) {
			compareObjects();
		} catch (NotInitializationException e1) {
			initializeObject(e1);
			play();
		}
	}

	private void initializeObject(NotInitializationException e) {
		try {
			/*
			 * if (e.getNonInitializedObject() instanceof EnteredNumber)... TODO
			 * if (attempt == 1) "����� ���������� � ���� \"������ �����\".\n"
			 * // + "����������� � ������ ��������.\n" // +
			 * "�������� ����� �� 1 �� 9 ������������. � ��� ���� ����� ��� �������."
			 * ;
			 */
			// if (e.getNonInitializedObject() instanceof ...)...
			// "������� ����� �� 1 �� 9:";
			printableObject.print(e.getMessageToPrint());
			e.getNonInitializedObject().initialize();
			// TODO if anyAttempt "������� � " + /*ATTEMPT + */".";
			//printableObject.print(attempt.getMessageAboutAttempts());
			

		} catch (IOException e1) {
			play();
		} catch (OutOfRangeException e1) {
			// if (e.getNonInitializedObject() instanceof EnteredNumber)...
			// "�������, ����������, ����� �� 1 �� 9!!!";
			printableObject.print(e1.getMessageToPrint());
			play();
		} catch (NotTrueFormatException e1) {
			// "�������, ����������, ����� �� 1 �� 9!!!";
			printableObject.print(e1.getMessageToPrint());
			play();
		}

	}

	private void compareObjects() {
		try {
			enteredNumber.compareWith(numberToGuess);
		} catch (NotBiggerException e1) {
			// "��������� ���� ����� " + /*������(������) + */" �������
			// �����.";
			printableObject.print(e1.getMessageToPrint());
			hasNextAttempt();
		} catch (NotSmallerException e1) {
			// "��������� ���� ����� " + /*������(������) + */" �������
			// �����.";
			printableObject.print(e1.getMessageToPrint());
			hasNextAttempt();
		} catch (NotInitializationException e) {
			initializeObject(e);
			play();
		}
	}

	private void hasNextAttempt() {
		try {
			if (attempt.hasNextElement()) {
				attempt.increment();
				throw new NotInitializationException(Messages.TRY_AGAIN_MESSAGE, enteredNumber);
			}
		} catch (NotInitializationException e2) {
			initializeObject(e2);
			play();
		} catch (NotNextElementException e2) {
			// "� ��� ����������� ��� �������. � ���������, ��
			// ���������(((";
			// "������������ ����� ���� " + /*numbertoguess + */".";
			// "������ �� ������� ���?";
			printableObject.print(e2.getMessageToPrint());
			// e2.printStackTrace();
			System.exit(0);
		}
	}

	@Override
	public void exit() {
		numberToGuess = null;
		enteredNumber = null;
		attempt = null;
		printableObject = null;
	}

}
