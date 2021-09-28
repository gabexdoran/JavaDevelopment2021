package project01package;

import java.util.ArrayList;

public class Tweet {
	private int polarity;
	private String id;
	private String user;
	private String tweet;
	
	public Tweet(int polarity, String id, String user, String tweet) {
		polarity = polarity;
		id = id;
		user = user;
		tweet = tweet;
	}
	
	public int getPolarity() {
		return polarity;
	}
	
	public void setPolarity(int polarity) {
		this.polarity = polarity;
	}
	
	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getTweet() {
		return tweet;
	}
	
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
}
