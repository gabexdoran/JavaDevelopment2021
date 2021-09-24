package project01package;

import java.util.ArrayList;

public class Tweet {
	private long id;
	private String user;
	private ArrayList<String> tweet;
	
	public Tweet(long id, String user) {
		id = id;
		user = user;
		
		tweet = new ArrayList<String>();
	}
	
	public long getID(long id) {
		return id;
	}
	
	public void setID(long id) {
		this.id = id;
	}
	
	public String getUser(String user) {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
}
