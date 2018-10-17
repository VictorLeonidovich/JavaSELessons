package gtn.printerapi;

import java.util.EnumSet;

public class PrinterConfiguration {
	private EnumSet<PrintSource> printerSources;

	public PrinterConfiguration() {
		printerSources = EnumSet.noneOf(PrintSource.class);
		printerSources.add(PrintSource.CONSOLE);
	}
	// TODO in future create interface
	public void enablePrinter(PrintSource printSource) {
		if (!printerSources.contains(printSource)) {
			printerSources.add(printSource);
		}
	}
	// TODO in future create interface
	public void disablePrinter(PrintSource printSource) {
		if (printerSources.contains(printSource)) {
			printerSources.remove(printSource);
		}
		if (printerSources.isEmpty()) {
			enablePrinter(PrintSource.CONSOLE);
		}
	}
	// TODO in future create interface
	public void enableAllPrinters() {
		for (PrintSource printSource : printerSources) {
			enablePrinter(printSource);
		}
	}
	// TODO in future create interface
	public void disableAllPrinters() {
		for (PrintSource printSource : printerSources) {
			// TODO may be Exception during remove operation
			disablePrinter(printSource);
		}
	}
	
	public EnumSet<PrintSource> getPrinters(){
		return printerSources;
	}
	

	// to delete - old methods
	/*public void enableAllPrinters() {
		enableConsolePrinter();
		enableFilePrinter();
		enableDataBasePrinter();
		enableVoicePrinter();
	}

	public void enableConsolePrinter() {
		if (!printerSources.contains(PrintSource.CONSOLE)) {
			printerSources.add(PrintSource.CONSOLE);
		}
	}

	public void enableFilePrinter() {
		if (!printerSources.contains(PrintSource.FILE)) {
			printerSources.add(PrintSource.FILE);
		}
	}

	public void enableDataBasePrinter() {
		if (!printerSources.contains(PrintSource.DATABASE)) {
			printerSources.add(PrintSource.DATABASE);
		}
	}

	public void enableVoicePrinter() {
		if (!printerSources.contains(PrintSource.VOICE)) {
			printerSources.add(PrintSource.VOICE);
		}
	}

	public void disableAllPrinters() {
		disableFilePrinter();
		disableDataBasePrinter();
		disableVoicePrinter();
		enableConsolePrinter();
	}

	public void disableConsolePrinter() {
		if (printerSources.contains(PrintSource.CONSOLE)) {
			printerSources.remove(PrintSource.CONSOLE);
		}
	}

	public void disableFilePrinter() {
		if (printerSources.contains(PrintSource.FILE)) {
			printerSources.remove(PrintSource.FILE);
		}
	}

	public void disableDataBasePrinter() {
		if (printerSources.contains(PrintSource.DATABASE)) {
			printerSources.remove(PrintSource.DATABASE);
		}
	}

	public void disableVoicePrinter() {
		if (printerSources.contains(PrintSource.VOICE)) {
			printerSources.remove(PrintSource.VOICE);
		}
	}*/

}
