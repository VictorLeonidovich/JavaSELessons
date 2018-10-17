package dataprocessing.simpledataprocessing;

public class Rule2 implements Comparable<Rule2> {
	private Character name;
	private String type;
	private Integer weight;

	public Character getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Integer getWeight() {
		return weight;
	}

	public Rule2(Character name, String type, Integer weight) {
		try {
			// checkName(name);
			this.name = name;
			// checkType(type);
			this.type = type;
			// checkWeight(weight);
			this.weight = weight;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
			// e.printStackTrace();
		}
	}

	private void checkName(Character checkedName) throws Exception {
		if (name == null || (checkedName < (char) 97 || checkedName > (char) 123)) {
			throw new Exception("Exception: Uncompatible name format " + checkedName);
		}
	}

	private void checkType(String checkedType) throws Exception {
		if (checkedType == null || !"child".equals(checkedType) || !"root".equals(checkedType)
				|| !"sub".equals(checkedType)) {
			throw new Exception("Exception: Uncompatible type format " + checkedType);
		}
	}

	private void checkWeight(Integer checkedWeight) throws Exception {
		if (checkedWeight == null || checkedWeight < 0 || checkedWeight >= 100) {
			throw new Exception("Exception: Uncompatible weight format " + checkedWeight);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rule2 other = (Rule2) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	@Override
	public int compareTo(Rule2 o) {
		int comparingResult = this.getName().compareTo(o.getName());
		if (comparingResult == 0) {
			comparingResult = new RuleTypeComparator().compare(this.getType(), o.getType());
			if (comparingResult == 0) {
				comparingResult = this.getWeight().compareTo(o.getWeight());
			}
		}
		return comparingResult;
	}

	@Override
	public String toString() {
		return "Rule \n[name=" + name + ", type=" + type + ", weight=" + weight + "]\n";
	}

	// needToRemove
	// otherRule = minRule
	public boolean isMaxRuleThan(Rule2 otherRule) {
		if (this.getName().equals(otherRule.getName())) {
			return isMaxTypeAndMaxWeight(otherRule.getType(), otherRule.getWeight());
		}
		return false;
	}

	private boolean isMaxTypeAndMaxWeight(String otherType, Integer otherWeight) {
		if (isMaxType(otherType)) {
			return true;
		} else if (isMaxWeight(otherWeight)) {
			return true;
		}
		return false;
	}

	private boolean isMaxType(String otherType) {
		int comparingResult = new RuleTypeComparator().compare(this.getType(), otherType);
		if (comparingResult == 1) {
			return true;
		}
		return false;
	}

	private boolean isMaxWeight(Integer otherWeight) {
		int resultOfComparing = this.getWeight().compareTo(otherWeight);
		if (resultOfComparing == -1) {
			return false;
		} else if (resultOfComparing == 1) {
			return true;
		} else if (resultOfComparing == 0) {
			return false;
		}
		return false;
	}

	public boolean isOtherRuleNameThan(Rule2 otherRule) {
		if (this.getName().equals(otherRule.getName())) {
			return false;
		}
		return true;
	}

}
