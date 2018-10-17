package gtn.printerapi;

public class ConsolePrinter extends AbstractPrinterImpl{

	@Override
	public void printMessage(String message) {
		System.out.println(message);
		
	}

	

}
