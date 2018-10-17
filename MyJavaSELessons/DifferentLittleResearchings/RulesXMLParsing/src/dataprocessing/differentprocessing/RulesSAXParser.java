package dataprocessing.differentprocessing;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import dataprocessing.differentprocessing.interfaces.Filterable;
import dataprocessing.differentprocessing.interfaces.Parseable;
import dataprocessing.differentprocessing.ruleandrules.RuleCreator;
import dataprocessing.differentprocessing.ruleandrules.Rules;
import dataprocessing.differentprocessing.ruleandrules.RulesCreator;

public class RulesSAXParser implements Parseable {
	private String xmlFileName; // = "D:/Other/teach/eclipse-jee-mars-R-win32/workspace/RulesXMLParsing/resources/simpleTestXML.txt";
	
	@Override
	public void setXMLDocumentPath(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	public void parseRulesByFilter(Rules rules, Filterable currentFilter) {
		RulesCreator rulesCreator = new RulesCreator(rules, currentFilter);
		RulesSAXParsingHandler rulesSAXParsingHandler = new RulesSAXParsingHandler();
		rulesSAXParsingHandler.setRulesCreator(rulesCreator);
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser;
		try {
			saxParser = factory.newSAXParser();
			saxParser.parse(xmlFileName, rulesSAXParsingHandler);
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
