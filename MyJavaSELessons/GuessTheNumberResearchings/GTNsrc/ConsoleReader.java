import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

	public static String readFromConsole() {
		String string = null;
		try (BufferedReader stringReader = new BufferedReader(new InputStreamReader(System.in))) {
			string = stringReader.readLine();
		} catch (IOException e1) {
			System.err.println("Ошибка ввода-вывода.");
			e1.printStackTrace();
		}
		return string;
	}

}
