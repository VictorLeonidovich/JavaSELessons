package dataprocessing.differentprocessing.ruleandrules;

public class RuleCreator {

	private Character name;
	private RuleType type;
	private Integer weight;

	public Rule createNewRuleFromTag(String ruleTag) {
		String[] ruleTagArray = ruleTag.trim().toLowerCase().split("\"");
		return createNewRuleFromAttributes(ruleTagArray[1], ruleTagArray[3], ruleTagArray[5]);
	}

	public Rule createNewRuleFromAttributes(String nameAttribute, String typeAttribute, String weightAttribute) {
		name = new Character(nameAttribute.trim().toLowerCase().charAt(0));
		type = RuleType.valueOf(typeAttribute.trim().toUpperCase());
		weight = Integer.parseInt(weightAttribute.trim());
		return new Rule(name, type, weight);
	}

	

	
}