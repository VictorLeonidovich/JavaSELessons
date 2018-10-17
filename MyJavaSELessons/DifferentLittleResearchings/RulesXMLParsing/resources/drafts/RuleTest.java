package dataprocessing.simpledataprocessing;

public class RuleTest {
	private static String minTestRuleString = "<rule name=\"a\" type=\"root\" weight=\"18\" />";
	private static String maxTestRuleString = "<rule name=\"a\" type=\"root\" weight=\"19\" />";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RuleCreator ruleCreator = new RuleCreator();
		Rule2 minRule = ruleCreator.createNewRuleFromTag(minTestRuleString);
		Rule2 maxRule = ruleCreator.createNewRuleFromTag(maxTestRuleString);
		System.out.println(maxRule.isMaxRuleThan(minRule));

	}

}
