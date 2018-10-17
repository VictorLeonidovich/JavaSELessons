package main;

public enum RobotType {
	BUILDER("build"),
	DESTROYER("destroy"),
	ALL("all");
	private String mission;

	private RobotType(String mission) {
		this.mission = mission;
	}

	public String getMission() {
		return mission;
	}
	
}
