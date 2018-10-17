package datapreparing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileCreator {
	private static final String rulesTag = "<%srules>";
	private static final String ruleTag = "\t<rule name=\"%s\" type=\"%s\" weight=\"%d\" />";
	private static char[] nameAttribute = new char[26];

	static {
		for (int i = 0; i < 26; i++) {
			nameAttribute[i] = (char) (i + 97);
			// System.out.println((char) (i + 97) + " " + i);
		}
	}

	private static final String[] typeAttribute = { "child", "sub", "root" };
	private static int weightAttribute = 100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:/Temp/simpleTestXML.txt")))) {
			bufferedWriter.write(String.format(rulesTag, ""));
			bufferedWriter.write(System.lineSeparator());
			for (int i = 0; i < 10; i++) {
				bufferedWriter.write(
						String.format(ruleTag,
								nameAttribute[(int)(Math.random() * 4)], 
								typeAttribute[(int)(Math.random() * 2)],
								(int)(Math.random() * weightAttribute)));
				bufferedWriter.write(System.lineSeparator());
			}
			
			bufferedWriter.write(String.format(rulesTag, "/"));
			//bufferedWriter.write(System.lineSeparator());
			
			System.out.println("testXML.txt - succesfelly created");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
