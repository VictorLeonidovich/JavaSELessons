package dataprocessing.differentprocessing;

import java.util.Collection;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import dataprocessing.differentprocessing.interfaces.Filterable;
import dataprocessing.differentprocessing.ruleandrules.Rule;
import dataprocessing.differentprocessing.ruleandrules.RuleCreator;
import dataprocessing.differentprocessing.ruleandrules.Rules;
import dataprocessing.differentprocessing.ruleandrules.RulesCreator;

public class RulesSAXParsingHandler extends DefaultHandler {
	private boolean isRules;
	private final String rulesTag;
	private final String ruleTag;
	private RulesCreator rulesCreator;
	private RuleCreator ruleCreator;
	private int count = 0;

	public void setRulesCreator(RulesCreator rulesCreator) {
		this.rulesCreator = rulesCreator;
	}

	public RulesSAXParsingHandler() {
		isRules = false;
		rulesTag = "rules";
		ruleTag = "rule";
		ruleCreator = new RuleCreator();
	}

	// realize logic to create, filter and add rule in rules

	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		if (rulesTag.equals(arg2)) {
			isRules = true;
		}
		if (isRules && ruleTag.equals(arg2)) {
			String nameAttribute = arg3.getValue("name");
			String typeAttribute = arg3.getValue("type");
			String weightAttribute = arg3.getValue("weight");
			Rule rule = ruleCreator.createNewRuleFromAttributes(nameAttribute, typeAttribute, weightAttribute);
			rulesCreator.createNeededRulesFromRule(rule);
		}
		countProcessedTags();

	}

	private void countProcessedTags() {
		count++;
		if (count % 100000 == 0) {
			System.out.println(String.format("parsed: %d lines...", count));
			// TODO would you like to continue?
		}
	}

	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		if (rulesTag.equals(arg2)) {
			isRules = false;
		}
	}

}
