package dataprocessing.simpledataprocessing.refactoring;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SimpleXMLRulesParser implements Closeable {
	private String ruleTag;
	private boolean isRuleTagReaded;
	private final BufferedReader bufferedReader;
	private final String RULES_TAG;
	private final String RULE_TAG = "<rule";
	private boolean isRulesTagFinded;

	public SimpleXMLRulesParser(String xmlFileName, String RULES_TAG) throws FileNotFoundException {
		this.RULES_TAG = RULES_TAG;
		isRulesTagFinded = false;
		isRuleTagReaded = false;
		bufferedReader = new BufferedReader(new FileReader(xmlFileName));
	}

	public boolean hasNextRuleTag() throws IOException {
		boolean hasNext = false;
		if (isRuleTagReaded) {
			hasNext = true;
		} else {
			String temporaryRuleTag = readNextTag().trim().toLowerCase();
			if (temporaryRuleTag.startsWith(RULE_TAG)) {
				this.ruleTag = temporaryRuleTag;
				isRuleTagReaded = true;
				hasNext = true;
			} else if (temporaryRuleTag.startsWith(String.format(RULES_TAG, "/"))) {
				hasNext = false;
				isRulesTagFinded = false;
				close();
			} 
		}
		return hasNext;
	}

	private String readNextTag() throws IOException {
		if (!isRulesTagFinded) {
			findRules();
		}
		return bufferedReader.readLine().trim().toLowerCase();
	}

	private void findRules() throws IOException {
		while (!(bufferedReader.readLine().trim().toLowerCase()).startsWith(String.format(RULES_TAG, ""))) {
		}
		isRulesTagFinded = true;
	}

	@Override
	public void close() throws IOException {
		bufferedReader.close();

	}

	public String getNextRuleTag() throws IOException {
		if (isRuleTagReaded) {
			isRuleTagReaded = false;
		} else {
			ruleTag = readNextTag();
		}
		return ruleTag;
	}

}
