package teaching;

import java.io.File;
import java.util.Arrays;

public class DirList {

	public static void main(String[] args) {

		File path = new File("D:\\Other\\teach\\eclipse-jee-mars-R-win32\\workspace");
		System.out.println(path);
		String[] list;
		if (args.length == 1) {
			list = path.list();
		} else {
			list = path.list(new DirFilter(""));
			//System.out.println(list);
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list) {
			System.out.println(dirItem);
		}

	}

}
