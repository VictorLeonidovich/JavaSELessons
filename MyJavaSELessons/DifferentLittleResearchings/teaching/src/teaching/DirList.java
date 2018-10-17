package teaching;

import java.io.File;
import java.util.Arrays;

public class DirList {
	public String[] list;
	private String filePath = "D:\\Other\\teach\\eclipse-jee-mars-R-win32\\workspace\\";
	public String[] getList(String[] args){
		File path = new File(filePath);
		//System.out.println(path);
		list = path.list(new DirFilter(".+\\D"));
		//System.out.println(list);
		return list;
	}	
	public static void main(String[] args) {
		DirList dirList = new DirList();
		dirList.getList(args);		
	Arrays.sort(dirList.list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : dirList.list) {
			
			System.out.println(dirItem);
		}
}
}	

	
		

	

		
		
