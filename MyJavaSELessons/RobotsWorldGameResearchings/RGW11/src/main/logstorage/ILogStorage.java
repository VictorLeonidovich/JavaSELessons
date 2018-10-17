package main.logstorage;

import java.util.List;

public interface ILogStorage {
	public void addStringLog(String stringLog);

	public String getStringLog();

	public List<String> getAllStringLogs();
}
