import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;


public class TestEOF {
	public static void main(String[] args) throws IOException{
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("D:\\Other\\teach\\eclipse-jee-mars-R-win32\\workspace\\FormattedMemoryInput\\src\\TestEOF.java"))));
		while(in.available() != 0){
			System.out.print((char)in.readByte());
		}
	}

}
