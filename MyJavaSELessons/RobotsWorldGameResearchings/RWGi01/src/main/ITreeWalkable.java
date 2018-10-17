package main;

public interface ITreeWalkable {
	public String[] goNextBranch(String nextBranch);

	public String[] goPreviosBranch(String[] currentBranch);
	// public Enum<? extends ITreeWalkable>[] valuesBranch();
}
