package chain;

public class MessageCreation {
	
	public void createMessage(){
		
	try {
		new StringExtraction().getNewExtractedString();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	
	}

}
