package gtn.managed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnteredNumber implements Inputable, Equalable {
	private Integer enteredNumber;

	@Override
	public void input() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			enteredNumber = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean isEqual(Equalable object) {
		return this.equals(object);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enteredNumber == null) ? 0 : enteredNumber.hashCode());
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
		EnteredNumber other = (EnteredNumber) obj;
		if (enteredNumber == null) {
			if (other.enteredNumber != null)
				return false;
		} else if (!enteredNumber.equals(other.enteredNumber))
			return false;
		return true;
	}
	

}
