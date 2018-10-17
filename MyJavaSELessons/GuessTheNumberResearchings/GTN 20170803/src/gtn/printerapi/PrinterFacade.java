package gtn.printerapi;

public class PrinterFacade {
	
	private PrinterConfiguration printerConfiguration;
	
	public PrinterFacade() {
		this(new PrinterConfiguration());
	}
	public PrinterFacade(PrinterConfiguration printerConfiguration) {
		this.printerConfiguration = printerConfiguration;
	}
	
	// TODO in future create interface
	public void printMessage(String message) {
		
		printerConfiguration.enablePrinter(PrintSource.CONSOLE);
		printerConfiguration.enablePrinter(PrintSource.FILE);
		
		for (PrintSource source : printerConfiguration.getPrinters()) {
			source.getSource().printMessage(message);
		}
		
		

	}

}
