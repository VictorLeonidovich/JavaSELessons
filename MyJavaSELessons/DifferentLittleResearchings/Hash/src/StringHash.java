
public class StringHash {
	public static void main(String [] args){
	//System.out.print("");
	int hash = 0;
	int M = 97;
	int R = 17;
	String s = "pig";
	for (int i = 0; i < s.length(); i++) {
		System.out.print(R*hash + " + " + s.charAt(i));
		hash = (R*hash + s.charAt(i))%M;
		System.out.println(" = " + hash);
	}
	
	}
}
