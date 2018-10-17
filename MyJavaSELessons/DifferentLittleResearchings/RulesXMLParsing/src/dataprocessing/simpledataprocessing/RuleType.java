package dataprocessing.simpledataprocessing;

public enum RuleType {
	ROOT("root"),
	SUB("sub"),
	CHILD("child");
	private String type;
	public String getType() {
		return type;
	}
	private RuleType(String type) {
		this.type = type;
	}
}