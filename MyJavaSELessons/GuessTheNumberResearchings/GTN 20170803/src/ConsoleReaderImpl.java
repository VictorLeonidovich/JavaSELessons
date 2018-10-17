import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReaderImpl implements IReader {

	@Override
	public String readObject() {
		String readedString = null;
		try (BufferedReader stringReader = new BufferedReader(new InputStreamReader(System.in))) {
			readedString = stringReader.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.println("Ошибка чтения строки.");
			e1.printStackTrace();
			readObject();
		}
		return readedString;
	}

}
