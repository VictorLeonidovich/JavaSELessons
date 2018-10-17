package main;

import java.lang.reflect.InvocationTargetException;

public class FrontController implements ITreeWalkable {
	// private final String startBranch;

	private String previousBranch;

	public FrontController() {
		// this.startBranch = "ClientAction";
	}

	@Override
	public String[] goNextBranch(String nextBranch) {
		String[] tempNextBranch = null;
		try {
			tempNextBranch = Branch.valueOf(nextBranch.toUpperCase()).getNextBranches();
		} catch (IllegalArgumentException e) {
			/*try {
				Class<?> clazz = Class.forName(previousBranch);
				clazz.getDeclaredMethod("doTask", String.class).invoke(clazz, nextBranch);
			} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// TODO Auto-generated catch block
			e.printStackTrace();*/
			String[] endOfBranch = {"end_of_branch"};
			return endOfBranch;
		}
		return tempNextBranch;
	}

	@Override
	public String[] goPreviosBranch(String[] currentBranch) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * public String[] getTreeBegin() { String[] nextBranch = new
	 * String[startBranch.length]; int index = 0; for (ClientAction clientAction
	 * : ClientAction.values()) { nextBranch[index] =
	 * clientAction.name().toLowerCase(); index++; } return nextBranch; }
	 * 
	 * public String[] goNextBranch(String message) {
	 * ClientAction.valueOf(message).getNextBranch();
	 * 
	 * return null;// TODO
	 * 
	 * }
	 */
}
