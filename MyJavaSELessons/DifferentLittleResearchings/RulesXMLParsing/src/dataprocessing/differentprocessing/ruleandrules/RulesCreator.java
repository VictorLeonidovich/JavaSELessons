package dataprocessing.differentprocessing.ruleandrules;

import dataprocessing.differentprocessing.interfaces.Filterable;

public class RulesCreator {
	private Rules rules;
	private Filterable currentFilter;

	public RulesCreator(Rules rules, Filterable currentFilter) {
		this.rules = rules;
		this.currentFilter = currentFilter;
		if (!rules.isEmpty()) {
			rules.clear();
		}
	}

	public void createNeededRulesFromRule(Rule rule) {
		
		rules = currentFilter.filterRule(rules, rule);

	}

}
