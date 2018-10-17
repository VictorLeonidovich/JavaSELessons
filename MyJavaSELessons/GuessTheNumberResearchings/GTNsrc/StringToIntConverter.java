
public class StringToIntConverter {

	public static int convertStringToInt(String string){
		
		/*if (string == null) {
			System.err.println("Игра не может быть начата. Ошибка нулевого объекта.");
			return 0;
		}*/
		
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
