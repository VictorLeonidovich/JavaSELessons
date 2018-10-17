
public class Main {

	public static void main(String[] args) {
		Publisher publisher = new Publisher();
		try {
			publisher.publishTopChar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			publisher.publishText("sa sa /f d");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			publisher.publishText("ASFASfEFhndbn");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			publisher.publishText("dzsfgfjj,iigl uilgu");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			publisher.publishText("asdgsdghfydafeg");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			publisher.publishTopChar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			publisher.publishAllChars();
		} catch (Exception e) {
			e.printStackTrace();
		}
		StreamPublisher streamPublisher = new StreamPublisher();

		streamPublisher.publishText("sa sa /f dASFASfEFhndbndzsfgfjj,iigl uilguasdgsdghfydafeg");

	}

}
