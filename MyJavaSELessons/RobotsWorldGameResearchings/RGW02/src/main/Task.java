package main;

import java.util.Date;

public class Task implements Comparable<Task> {
	private final long id;
	private final Date date;

	public Task(long id) {
		this.id = id;
		this.date = new Date();
	}

	public long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public int compareTo(Task o) {
		return this.getDate().compareTo(o.getDate());
	}

}
