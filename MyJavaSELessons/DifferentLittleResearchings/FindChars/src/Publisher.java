import java.util.Map;
import java.util.TreeMap;

public class Publisher {
	private final Map<Character, Integer> map = new TreeMap<>();

	public void publishText(String str) throws Exception {
		Character simbol;
		Integer count;
		if (str == null) {
			throw new Exception("no text");
		}
		for (int i = 0; i < str.length(); i++) {
			simbol = str.charAt(i);
			if ((count = map.get(simbol)) != null) {
				map.put(simbol, count + 1);
			} else {
				map.put(simbol, 1);
			}
		}
	}

	public void publishTopChar() throws Exception {
		Character simbol = null;
		Integer count = null;
		if (map.isEmpty()) {
			throw new Exception("no chars in the map");
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (simbol == null) {
				simbol = entry.getKey();
				count = entry.getValue();
			} else if (entry.getValue() > count) {
				simbol = entry.getKey();
				count = entry.getValue();
			}
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue().equals(count)) {
				System.out.println("Top simbol is: " + entry.getKey() + ", count is: " + entry.getValue());
			}
		}
	}

	public void publishAllChars() throws Exception {
		if (map.isEmpty()) {
			throw new Exception("no chars in the map");
		}
		System.out.println("All chars are: " + map.toString());
	}

}
