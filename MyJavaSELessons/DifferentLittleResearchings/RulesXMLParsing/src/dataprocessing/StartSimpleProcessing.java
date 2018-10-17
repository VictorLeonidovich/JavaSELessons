package dataprocessing;

import java.io.IOException;

import dataprocessing.simpledataprocessing.refactoring.RuleCreator;
import dataprocessing.simpledataprocessing.refactoring.Rules;


public class StartSimpleProcessing {
	private final static String XML_FILE_NAME = "D:/Other/teach/eclipse-jee-mars-R-win32/workspace/RulesXMLParsing/resources/simpleTestXML.txt";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RuleCreator ruleCreator = new RuleCreator();
		Rules rules = new Rules(ruleCreator);
		rules.setXMLFileName(XML_FILE_NAME);
		//rules.getMaxRules();
		System.out.println(rules.getMaxRules().toString());
	}

}
