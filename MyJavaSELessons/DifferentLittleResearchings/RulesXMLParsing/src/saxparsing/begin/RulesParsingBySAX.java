package saxparsing.begin;

import java.util.Arrays;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RulesParsingBySAX extends DefaultHandler{

	@Override
	public void endDocument() throws SAXException {
		System.out.println("endDocument");
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("startDocument");
	}

	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		//System.out.println(arg0 + " -arg0 " + arg1 + " - arg1 " + arg2 + " - arg2 "/* + arg3 + " - arg3 "*/);
		super.endElement(arg0, arg1, arg2);
	}

	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		//System.out.println(arg0 + " -arg0 " + arg1 + " - arg1 " + arg2 + " - arg2 " + arg3.getValue(2) + " - arg3 ");
	}

	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		System.out.println(/*Arrays.toString(arg0) + " -arg0 " + */arg1 + " - arg1 " + arg2 + " - arg2 ");
	}

	

}
