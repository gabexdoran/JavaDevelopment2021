package project01package;

import java.util.ArrayList;

public class Tweet {
	private long id;
	private String user;
	private String tweet;
	private int polarity;
	
	public Tweet(long id, String user, String tweet, int polarity) {
		id = id;
		user = user;
		tweet = tweet;
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
