package main.enums;

import main.ITreeWalkable;
import main.robotadding.RobotAdding;

public enum ClientActionE /*implements ITreeWalkable*/ {
	ADD_ROBOT(/*new RobotAdding()*/), SEND_TASK(/*new TaskSending()*/);
	/*private IBranchStorage clientAction;

	private ClientActionE(IBranchStorage clientAction) {
		this.clientAction = clientAction;
	}

	public ITreeWalkable getNextBranch() {
		return clientAction;
	}

	@Override
	public String[] goNextBranch(String message) {
		this.clientAction
		return null;
	}

	@Override
	public Enum<? extends ITreeWalkable>[] valuesBranch() {
		return ClientAction.values();
	}*/
}
