package teaching;

import java.io.File;
import java.util.ArrayList;

public class Directory {
	private File filePath;
	private String stringPath;
	private StringBuffer directoryBuilder = new StringBuffer(stringPath);
	private ArrayList<File> directories = new ArrayList<>();
	private ArrayList<File> files = new ArrayList<>();
	public Directory(String stringPath) {
		this.filePath = new File(stringPath);
		this.stringPath = stringPath;

	}
	
	
	
	
	
	private String[] getList(File filePath){
		String[] list = filePath.list();
		return list;
	}
	
	private String builderOfDirectory(String directoryElement) {
		if (filePath.isDirectory()){directories.add(filePath);}
		return directoryBuilder.append("\\").append(directoryElement).toString();
	}
	
	
	public String toString(){
		
		return "";
	}
	

}
