import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPublisher {
	private final Map<Character, Integer> map = new TreeMap<>();

	public void publishText(String str) {
		/*
		 * Character topChar = str.chars() .mapToObj(x -> (char)x)
		 * .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
		 * .entrySet().stream() .max(comparingByValue()) .get() .getKey();
		 */
		final Map<Character, Long> collect = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		collect.forEach((topChar, count) -> System.out.println("Top simbol is: " + topChar + ", count is: " + count));
		collect.entrySet().stream()
				.sorted(Comparator.<Entry<Character, Long>> comparingLong(Entry::getValue).reversed()).limit(10)
				.forEach((e) -> System.out.println("Top simbol is: " + e.getKey() + ", count is: " + e.getValue()));

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
