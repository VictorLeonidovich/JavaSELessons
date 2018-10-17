package dataprocessing.simpledataprocessing;

public class Rule implements Comparable<Rule> {
	private Character name;
	private RuleType type;
	private Integer weight;

	public Character getName() {
		return name;
	}

	public RuleType getType() {
		return type;
	}

	public Integer getWeight() {
		return weight;
	}

	public Rule(Character name, RuleType type, Integer weight) {
		this.name = name;
		this.type = type;
		this.weight = weight;
	}

	@Override
	public int compareTo(Rule otherRule) {
		int comparingResult = this.getName().compareTo(otherRule.getName());
		if (comparingResult == 0) {
			comparingResult = this.getType().compareTo(otherRule.getType());
			if (comparingResult == 0) {
				comparingResult = this.getWeight().compareTo(otherRule.getWeight());
			}
		}
		return comparingResult;
	}

	@Override
	public String toString() {
		return "Rule \n[name=" + name + ", type=" + type.getType() + ", weight=" + weight + "]\n";
	}

	public boolean hasSameName(Rule iteratedRule) {
		if (this.getName().equals(iteratedRule.getName())) {
			return true;
		}
		return false;
	}

	public boolean isMoreThan(Rule iteratedRule) {
		
		if (hasSameName(iteratedRule)) {
			//System.out.println("ordinal() max? " + (this.getType().ordinal() > iteratedRule.getType().ordinal()));
			//System.out.println("this.ord: " + (this.getType().ordinal() + "iteratedRule.ord: " +  iteratedRule.getType().ordinal()));
			if (this.getType().ordinal() > iteratedRule.getType().ordinal()) {
				
				return true;
			} else if (this.getType().ordinal() == iteratedRule.getType().ordinal()) {
				if (this.getWeight().compareTo(iteratedRule.getWeight()) == 1) {
					return true;
				}
			}
		}
		return false;
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
		Rule other = (Rule) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

}
