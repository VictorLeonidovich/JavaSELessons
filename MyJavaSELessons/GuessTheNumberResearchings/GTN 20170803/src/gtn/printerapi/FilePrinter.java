package gtn.printerapi;

import java.io.BufferedWriter;
import java.io.IOException;

public class FilePrinter extends AbstractPrinterImpl {
	
	private final BufferedWriter bufferedWriter;
	
	public FilePrinter() {
		// TODO to future - Factory, injection
		this.bufferedWriter = new BufferedFileWriterImpl().createBufferedFileWriter();
	}
	
	@Override
	public void printMessage(String message) {
		try {
			bufferedWriter.write(message);
			bufferedWriter.write(System.lineSeparator());
			bufferedWriter.flush();
			PrintSource.CONSOLE.getSource().printMessage("message \"" + message + "\" succesfully printed in file.");
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// TODO close BufferedWriter
		}

	}

}
