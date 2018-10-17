package test;

import main.Branch;
import main.FrontController;

public class Main {
	private static FrontController frontController = new FrontController();
	public static void main(String[] args) {
		// String[] tempNextBranch =
		// Branch.valueOf("client_action".toUpperCase()).getNextBranches();
		// System.out.println(tempNextBranch);
		//FrontController frontController = new FrontController();

		//String[] branches = frontController.goNextBranch("client_action");
		StringBuilder stringBuilder = new StringBuilder();
		walkThroughAllBranches(stringBuilder, "rwg");
	}

	private static void walkThroughAllBranches(StringBuilder stringBuilder, String branch) {
		stringBuilder.append(branch).append("/");
		String[] tempNextBranch = frontController.goNextBranch(branch);
		for (String iteratedBranch : tempNextBranch) {
			if ("end_of_branch".equals(iteratedBranch)) {
				System.out.println(stringBuilder.toString());
				break;
			}
			walkThroughAllBranches(new StringBuilder(stringBuilder.toString()), iteratedBranch);
		}
		
	}
}
