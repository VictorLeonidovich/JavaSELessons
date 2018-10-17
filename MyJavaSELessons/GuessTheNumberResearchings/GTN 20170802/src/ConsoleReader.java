import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

	public int readFromConsole() {
		String string = null;
		try (BufferedReader stringReader = new BufferedReader(new InputStreamReader(System.in))) {
			string = stringReader.readLine();
		} catch (IOException e1) {
			System.err.println("Ошибка ввода-вывода.");
			e1.printStackTrace();
		}
		return convertStringToInt(string);
	}

	public int convertStringToInt(String string) {

		/*
		 * if (string == null) { System.err.println(
		 * "Игра не может быть начата. Ошибка нулевого объекта."); return 0; }
		 */

		Integer convertedString = null;
		try {
			convertedString = Integer.parseInt(string);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return convertedString;

	}

}
