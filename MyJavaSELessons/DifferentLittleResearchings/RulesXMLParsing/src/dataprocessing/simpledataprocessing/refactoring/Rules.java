package dataprocessing.simpledataprocessing.refactoring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Set;
import java.util.TreeSet;

public class Rules {
	private final Set<Rule> maxRulesList = new TreeSet<>();
	private final String RULES_TAG = "<%srules>";
	private RuleCreator ruleCreator;
	private String xmlFileName;
	private int count = 0;
	private SimpleXMLRulesParser xmlRulesParser;

	public Rules(RuleCreator ruleCreator) {
		this.ruleCreator = ruleCreator;
	}

	public void setXMLFileName(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	public TreeSet<Rule> getMaxRules() throws IOException {
		if (!maxRulesList.isEmpty()) {
			maxRulesList.clear();
		}
		Rule temporaryRule;
		xmlRulesParser = new SimpleXMLRulesParser(xmlFileName, RULES_TAG);
		while (xmlRulesParser.hasNextRuleTag()) {
			String temporaryRuleTag = xmlRulesParser.getNextRuleTag();
			temporaryRule = ruleCreator.createNewRuleFromTag(temporaryRuleTag);
			temporaryRule = getMaxRule(temporaryRule);
			maxRulesList.add(temporaryRule);
			count++;
			if (count % 100000 == 0) {
				System.out.println(String.format("parsed: %d lines...", count));
				// TODO would you like to continue?
			}
		}
		return (TreeSet<Rule>) maxRulesList;
	}

	// addMaxRule() ??? OR toCreatenaxRulesList ???
	private Rule getMaxRule(Rule temporaryRule) {
		// TODO temporaryRule - not null
		if (maxRulesList.isEmpty()) {
			return temporaryRule;
		}
		Rule minRule = temporaryRule;
		Rule maxRule = temporaryRule;
		boolean needToRemove = false;
		for (Rule iteratedRule : maxRulesList) {
			if (temporaryRule.hasSameName(iteratedRule)) {
				if (temporaryRule.isMoreThan(iteratedRule)) {

					maxRule = temporaryRule;
					minRule = iteratedRule;
					needToRemove = true;
					break;
				} else {
					maxRule = iteratedRule;
					needToRemove = false;
					break;
				}
			}
		}
		if (needToRemove) {
			removeRule(minRule);
		}

		return maxRule;
	}

	private void addRule(Rule maxRule) {
		maxRulesList.add(maxRule);
	}

	private void removeRule(Rule minRule) {
		maxRulesList.remove(minRule);
	}

	@Override
	public String toString() {
		return "Rules:\n [rules=\n" + maxRulesList + "]\n";
	}

}
