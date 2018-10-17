package dataprocessing.simpledataprocessing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RuleCreatorTest {
	private String testRuleString = "<rule name=\"a\" type=\"child\" weight=\"17\" />";
	private RuleCreator ruleCreator;
	
	@Before
	public void init(){
		ruleCreator = new RuleCreator();
		System.out.println("Test starts.");
	}

	@Test
	public void testCreateNewRuleFromTag() {
		Character testName = ruleCreator.createNewRuleFromTag(testRuleString).getName();
		//assertNotNull(testName);
		assertSame(testName, 'a');
		//String testType = ruleCreator.createNewRuleFromTag(testRuleString).getType();
		assertNotNull(testType);
		assertSame(testType, "child");
		Integer testWeight = ruleCreator.createNewRuleFromTag(testRuleString).getWeight();
		assertNotNull(testWeight);
		assertSame(testWeight, 17);
	}
	
	@After
	public void end(){
		System.out.println("Test finished.");
		System.out.println("Created rule: " + ruleCreator.createNewRuleFromTag(testRuleString).toString());
	}

}
