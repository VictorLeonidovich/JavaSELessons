import java.io.*;

public class MemoryInput {

	public static void main(String[] args) throws IOException {
		StringReader in = new StringReader(
				BufferedInputFile.read("D:\\Other\\teach\\eclipse-jee-mars-R-win32\\workspace\\MemoryInput\\src\\MemoryInput.java"));
		int c;
		while((c = in.read())!= -1){
			System.out.print((char)c);
		}

	}

}
