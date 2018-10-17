package dataprocessing.differentprocessing.interfaces;


import dataprocessing.differentprocessing.ruleandrules.Rules;

public interface Parseable {
	public void setXMLDocumentPath(String xmlFileName);
	public void parseRulesByFilter(Rules rules, Filterable currentFilter);

}
