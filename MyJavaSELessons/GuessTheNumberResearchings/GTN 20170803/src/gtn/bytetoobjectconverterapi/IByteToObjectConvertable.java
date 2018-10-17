package gtn.bytetoobjectconverterapi;

import java.util.ArrayList;

public interface IByteToObjectConvertable<T> {
	public ArrayList<T> convertByteToObject(ArrayList<Byte> listOfBytes);

}
