package main;

public enum Mission {
BUILD, DESTROY, KILL, DEFEND, KILLYOURSELF;
	/*private Action action;
	private Mission(Action action) {
		this.action = action;
	}
	public Action getAction(RobotTypeUtils robotType){
		getTimeOutRate(robotType);
		return action;
	}
	private double getTimeOutRate(RobotTypeUtils robotType) {
		double timeOutRate;
		// TODO if task != null or parameters
		if (robotType.isNativeMission(this)) {
			timeOutRate = 1.0;
		} else if (this.equals(Mission.KILLYOURSELF)) {
			timeOutRate = 5.0;
		} else {
			timeOutRate = 2.5;
		}
		return timeOutRate;
	}*/
}
