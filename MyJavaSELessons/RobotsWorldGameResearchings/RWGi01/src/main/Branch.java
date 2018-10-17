package main;

public enum Branch {
	  RWG(new String[] { "home", "rest_api_information", "client_action", "logs" })
	, CLIENT_ACTION(new String[] { "add_robot", "send_task" })
	, ADD_ROBOT(new String[] { "adder", "multiplier" })
	, SEND_TASK(new String[] { "concrete_robot", "all_robots" })
	, CONCRETE_ROBOT(new String[] { "do_task", "kill_yourself" })
	, ALL_ROBOTS(new String[] { "do_task", "kill_yourself" })
	, DO_TASK(new String[] { "add", "multiply" })
	;
		private IExecutionable execution;
private String[] action;

	private Branch(/*IExecutionable execution, */String[] action) {
		this.execution = execution;
		this.action = action;
	}

	public String[] getNextBranches() {
		return action;
	}
}
