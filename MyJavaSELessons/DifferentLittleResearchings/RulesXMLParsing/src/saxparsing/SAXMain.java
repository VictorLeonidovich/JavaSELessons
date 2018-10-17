package saxparsing;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import saxparsing.begin.RulesParsingBySAX;

public class SAXMain {
	private final static String XML_FILE_NAME = "D:/Other/teach/eclipse-jee-mars-R-win32/workspace/RulesXMLParsing/resources/simpleTestXML.txt";


	public static void main(String[] args) {
		
		
		RulesParsingBySAX rulesParsingBySAX = new RulesParsingBySAX();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser;
		try {
			saxParser = factory.newSAXParser();
			saxParser.parse(XML_FILE_NAME, rulesParsingBySAX);
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//rulesParsingBySAX.printInfo();

	}

}
