package teaching;

import java.io.File;
import java.util.Arrays;

public class DirList {

	public static void main(String[] args) {

		File path = new File(".\\.projects");
		String[] list;
		if (args.length == 1) {
			list = path.list();
		} else {
			list = path.list(new DirFilter("."));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list) {
			System.out.println(dirItem);
		}

	}

}
