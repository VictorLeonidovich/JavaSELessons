package test;


import main.RobotTypeTarget;

public class TestRTT {

	public static void main(String[] args) {
		for (RobotTypeTarget robotTypeTarget : RobotTypeTarget.values()) {
			System.out.println(robotTypeTarget + " -> " + robotTypeTarget.getRobotType().toString());
		}

	}

}
