package dataprocessing.simpledataprocessing.refactoring;

public class RuleCreator {

	private Character name;
	private RuleType type;
	private Integer weight;

	public Rule createNewRuleFromTag(String ruleTag) {
		//System.out.println("Rule tag: " + ruleTag);
		String[] ruleTagArray = ruleTag.trim().toLowerCase().split("\"");
		
		name = new Character(ruleTagArray[1].trim().toLowerCase().charAt(0));
		type = RuleType.valueOf(ruleTagArray[3].trim().toUpperCase());
		weight = Integer.parseInt(ruleTagArray[5].trim());

		Rule temporaryRule = new Rule(name, type, weight);
		//System.out.println("Rule created: " + temporaryRule.toString());

		return temporaryRule;
	}

	
}