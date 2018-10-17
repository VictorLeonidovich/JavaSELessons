package main;

import java.text.DateFormat;
import java.util.Date;

public class Log implements Comparable<Log> {
	private final String message;
	private final Date date;

	public Log(String message, Date date) {
		this.message = message;
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public int compareTo(Log o) {
		if (o.getDate() == null) {
			System.err.println("null Date in Log.class in public int compareTo(Log o)");
			System.exit(0);
		}
		return this.getDate().compareTo(o.getDate());
	}

	@Override
	public String toString() {
		return "Log [message=" + message + ", date=" + DateFormat.getInstance().format(date) + "]";
	}

}
