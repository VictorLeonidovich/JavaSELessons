package classes;

public class RandomNumber {
	private Integer randomNumber;
	
	public Integer getRandomNumber(){
		if (randomNumber == null) {
			generateRandomNumber();
		}
		return this.randomNumber;
	}
	public void generateRandomNumber(){
		this.randomNumber = (Integer)(int)(Math.random() * 9) + 1;
	}

}
