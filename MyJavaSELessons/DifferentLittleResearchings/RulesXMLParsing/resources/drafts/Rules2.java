package dataprocessing.simpledataprocessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Rules2 {
	private final ArrayList<Rule2> rules = new ArrayList<>();
	// private BufferedReader bufferedReader;
	private final String RULES_TAG = "<%srules>";
	private RuleCreator ruleCreator;
	private String xmlFileName;
	private int count = 0;

	public void setXMLFileName(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	public Rules2(RuleCreator ruleCreator) {
		this.ruleCreator = ruleCreator;
	}

	// TODO нужные методы
	// unicRules
	// maxRules
	public ArrayList<Rule2> getMaxRules() throws IOException {
		if (!rules.isEmpty()) {
			rules.clear();
		}
		Rule2 temporaryRule;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(xmlFileName))) {
			String temporaryRuleTag = bufferedReader.readLine().trim().toLowerCase();
			if (temporaryRuleTag.startsWith(String.format(RULES_TAG, ""))) {
				while (!(temporaryRuleTag = bufferedReader.readLine().trim().toLowerCase())
						.startsWith(String.format(RULES_TAG, "/"))) {
					temporaryRule = ruleCreator.createNewRuleFromTag(temporaryRuleTag);
					if (rules.isEmpty()) {
						rules.add(temporaryRule);
						System.out.println("Added: " + temporaryRule);
					} else {
						addMaxRuleAndDeleteMinRule(temporaryRule);
					}
					System.out.println(count++);
				}
			}
		}
		// TODO would you like to continue?
		Collections.sort(rules);
		return rules;
	}

	private void addMaxRuleAndDeleteMinRule(Rule2 temporaryRule) {
		Rule2 minRule = temporaryRule;
		Rule2 maxRule = temporaryRule;
		boolean needToRemove = false;
		boolean needToAdd = false;
		for (Rule2 iteratedRule : rules) {
			if (temporaryRule.isOtherRuleNameThan(iteratedRule)) {
				maxRule = temporaryRule;
				needToAdd = true;
				break;
			} else if (temporaryRule.isMaxRuleThan(iteratedRule)) {
				minRule = iteratedRule;
				maxRule = temporaryRule;
				needToRemove = true;
				needToAdd = true;
				break;
			}
		}
		if (needToRemove) {
			rules.remove(minRule);
			System.out.println("Removed: " + minRule);
		}
		if (needToAdd) {
		rules.add(maxRule);
		System.out.println("Added: " + maxRule);
		}
	}

	@Override
	public String toString() {
		return "Rules:\n [rules=\n" + rules + "]\n";
	}

}
