package gtn.printerapi;

public enum PrintSource implements IPrintSourceSetting {
	// TODO to future - factory, injection
	CONSOLE(new ConsolePrinter()) {
		@Override
		public void setPrintSource(IPrinter printSource) {
			super.source = printSource;
		}
	},
	FILE(new FilePrinter()) {
		@Override
		public void setPrintSource(IPrinter printSource) {
			super.source = printSource;
		}
	},
	DATABASE(new DataBasePrinter()) {
		@Override
		public void setPrintSource(IPrinter printSource) {
			super.source = printSource;
		}
	},
	VOICE(new VoicePrinter()) {
		@Override
		public void setPrintSource(IPrinter printSource) {
			super.source = printSource;
		}
	};
	private IPrinter source;

	private PrintSource(IPrinter source) {
		this.source = source;
	}

	public IPrinter getSource() {
		return source;
	}
	
	abstract public void setPrintSource(IPrinter printSource);

}
