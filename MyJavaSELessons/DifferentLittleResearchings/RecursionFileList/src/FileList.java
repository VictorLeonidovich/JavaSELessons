import java.io.File;

public class FileList {
	private File folder = new File("D:/Other/teach/eclipse-jee-mars-R-win32/workspace/");
	public void processFileFromFolder (File folder){
		File [] folderEntries = folder.listFiles();
		for (File entry : folderEntries){
			if (entry.isDirectory()) {
				processFileFromFolder(entry);
				System.out.println(entry + " ----- isDirectory");
				continue;
			}else{System.out.println(entry + " ----- isFile");}
		}
		
	}

	public static void main(String[] args) {
		
		FileList fileList = new FileList();
		fileList.processFileFromFolder (fileList.folder);
			
		

		
		


	}

}
