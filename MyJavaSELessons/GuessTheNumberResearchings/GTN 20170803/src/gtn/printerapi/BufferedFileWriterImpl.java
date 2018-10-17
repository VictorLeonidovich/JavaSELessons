package gtn.printerapi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileWriterImpl implements IBufferedFileWriter {
	private static final String defaultAbsoluteFilePath = "C://temp//temp.txt";
	private final String absoluteFilePath;
	private BufferedWriter bufferedWriter;

	public BufferedFileWriterImpl() {
		this(defaultAbsoluteFilePath);
	}

	public BufferedFileWriterImpl(String absoluteFilePath) {
		this.absoluteFilePath = absoluteFilePath;
	}

	@Override
	public BufferedWriter createBufferedFileWriter() {
		try {
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
		} catch (IOException e1) {
			System.out.println("error in bufferedWriter.close() of class BufferedFileWriterImpl");
			e1.printStackTrace();
		}

		try {
			bufferedWriter = new BufferedWriter(new FileWriter(absoluteFilePath));
		} catch (IOException e) {
			System.out.println(
					"error in createBufferedFileWriter(String absoluteFilePath) of class BufferedFileWriterImpl");
			e.printStackTrace();
		}
		return bufferedWriter;
	}

}
