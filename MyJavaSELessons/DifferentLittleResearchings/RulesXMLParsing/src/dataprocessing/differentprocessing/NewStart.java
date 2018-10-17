package dataprocessing.differentprocessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dataprocessing.differentprocessing.interfaces.Filterable;
import dataprocessing.differentprocessing.interfaces.Parseable;
import dataprocessing.differentprocessing.ruleandrules.Rules;
import dataprocessing.differentprocessing.ruleandrules.RulesCreator;
import dataprocessing.simpledataprocessing.refactoring.RuleCreator;

public class NewStart {
	private final static String XML_FILE_NAME = "D:/Other/teach/eclipse-jee-mars-R-win32/workspace/RulesXMLParsing/resources/simpleTestXML.txt";

	private static Parseable currentParser;
	private static Filterable currentFilter;

	public static void main(String[] args) throws IOException {
		System.out.println("Please, enter XML parser: ");
		System.out.println("'simple' to use Simple Parser,");
		System.out.println("'sax' to use SAX Parser,");
		System.out.println("'dom' to use DOM Parser,");
		System.out.println("'stax' to use StAX Parser.");
		String parserName = "";
		String filterName = "";
		String documentPath = XML_FILE_NAME;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			parserName = reader.readLine();
			currentParser = new ParserFactory().getParser(parserName);
			currentParser.setXMLDocumentPath(XML_FILE_NAME);
			System.out.println(parserName + " parser succesfully choosed.\r\n");
			
			System.out.println("Please, enter rule filter: ");
			System.out.println("'max' to use filter for only max rule,");
			System.out.println("'min' to use filter for only min rule,");
			System.out.println("'distinct' to use filter for only distinct rule,");

			
			filterName = reader.readLine();
			currentFilter = new FilterFactory().getFilter(filterName);

			System.out.println(filterName + " filter succesfully choosed.\r\n");
			//System.out.println("Please, enter full XML document path: ");
			//documentPath = reader.readLine();
			//currentParser.setXMLDocumentPath(documentPath);
		}
		Rules rules = new Rules();
		
		//run along chain
		currentParser.parseRulesByFilter(rules, currentFilter);
		//RulesCreator.createRules(rules, currentParser, currentFilter);
		System.out.println(rules.toString());

		/*
		 * Parser parser = new Parser().getParser(parserName);
		 * 
		 * RuleCreator ruleCreator = new RuleCreator(); Rules rules = new
		 * Rules(ruleCreator); rules.setXMLFileName(XML_FILE_NAME); //
		 * rules.getMaxRules();
		 * System.out.println(rules.getMaxRules().toString());
		 */
	}

}
