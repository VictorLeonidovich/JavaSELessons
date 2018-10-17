package gtn.managed;

public interface Equalable {
	public boolean isEqual(Equalable object);
	public boolean equals(Object obj);
	public int hashCode();

}
