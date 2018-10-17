
public class StringToIntConverter {
	public int convertStringToInt(String string){
		Integer convertedString = null;
		try {
			convertedString = (int)Integer.parseInt(string);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.err.println("Ошибка конвертации строки в целое число.");
			e.printStackTrace();
		}
		return convertedString;
		
	}

}
