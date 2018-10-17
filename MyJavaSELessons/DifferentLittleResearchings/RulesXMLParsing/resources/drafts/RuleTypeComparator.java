package dataprocessing.simpledataprocessing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RuleTypeComparator implements Comparator<String>{
	private final Map<String, Integer> ruleTypesMap = new HashMap<>();
	
	private Integer getPriority(String ruleType) {
		return ruleTypesMap.get(ruleType);
	}

	public RuleTypeComparator() {
		this.ruleTypesMap.put("child", 1);
		this.ruleTypesMap.put("sub", 2);
		this.ruleTypesMap.put("root", 3);
	}

	@Override
	public int compare(String ruleType0, String ruleType1) {
		return -getPriority(ruleType0).compareTo(getPriority(ruleType1));
	}

}
