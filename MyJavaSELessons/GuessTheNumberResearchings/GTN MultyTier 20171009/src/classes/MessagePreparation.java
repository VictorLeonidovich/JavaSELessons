package classes;

public class MessagePreparation {
	private final String colontitle = "--==*************************************==--";
	private String message;
	public void setMessage(String message) {
		this.message = message;
	}

	
	private String prepareMessageToClient(String message) {
		String temporaryMessage = null;
		temporaryMessage = colontitle + System.lineSeparator() + message + System.lineSeparator() + colontitle;
		return temporaryMessage;

	}

	private Integer prepareMessageToServer(String message) {
		Integer temporaryMessage = null;
		try {
			temporaryMessage = Integer.parseInt(message);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temporaryMessage;
	}
	/*public String sendMessageAndGetResponse(String message){
		
	}*/
}
