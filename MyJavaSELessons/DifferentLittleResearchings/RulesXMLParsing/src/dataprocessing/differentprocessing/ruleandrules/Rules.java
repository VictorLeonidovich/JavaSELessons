package dataprocessing.differentprocessing.ruleandrules;

import java.util.Set;
import java.util.TreeSet;


public class Rules {
	private final Set<Rule> rulesList = new TreeSet<>();
	
	public boolean isEmpty(){
		return rulesList.isEmpty();
	}
	public void clear(){
		rulesList.clear();
	}
	public void addRule(Rule rule) {
		rulesList.add(rule);
	}

	public void removeRule(Rule rule) {
		rulesList.remove(rule);
	}

	@Override
	public String toString() {
		return "Rules:\n [rules=\n" + rulesList + "]\n";
	}
}
