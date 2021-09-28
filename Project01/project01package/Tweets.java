package project01package;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Tweets {
	private ArrayList<Tweet> tweets;
	
	public ArrayList<Tweet> readFile(String fileName) {
		String line = null;
		BufferedReader bufferedReader = null;
		int convertedPolarity = 0;
		
		try {
			File myFile = new File(fileName);
			FileReader fileReader = new FileReader(myFile, StandardCharsets.UTF_8);
			bufferedReader = new BufferedReader(fileReader);
			
			while ((line = bufferedReader.readLine()) != null) {
				String[] lineElements = line.split(",");
				
				convertedPolarity = Integer.parseInt(lineElements[0]);
				
				Tweet tweet = new Tweet(convertedPolarity, lineElements[1], lineElements[2], lineElements[3]);
				tweets.add(tweet);
			}
		} 
		catch (IOException e) {
			System.out.println("ERROR: IOException thrown!!!");
		}
		
		return tweets;
	}
	
	public void add(Tweet tweet) {
		tweets.add(tweet);
	}
	
	public void remove(Tweet tweet) {
		tweets.remove(tweet);
	}
	
	public Tweet searchByID(String ID) {
		int index = tweets.indexOf(ID);
		
		if (index > -1) {
			Tweet tweet = tweets.get(index);
			return tweet;
		}
		else {
			System.out.println("ERROR: Tweet not found!!!");
			return null;
		}
	}
	
	public Tweet searchByUser(String user) {
		int index = tweets.indexOf(user);
		
		if (index > -1) {
			Tweet tweet = tweets.get(index);
			return tweet;
		}
		else {
			System.out.println("ERROR: Tweet not found!!!");
			return null;
		}
	}
	
	public String[] retriveAllIDs() {
		String[] allIDs = null;
		Iterator itr = tweets.iterator();
		int i = 0;
		
		while (itr.hasNext()) {
			allIDs[i] = (String) itr.next();
		}
		
		return allIDs;
	}
	
	public ArrayList<Tweet> predictor(ArrayList<Tweet> tweets) {
		Random randGen = new Random();
		Iterator itr = tweets.iterator();
		Tweet currentTweet = new Tweet(0, " ", " ", " ");
		int randPolarity = 0, currentPolarity = 0, i = 0;
		
		while (itr.hasNext()) {
			randPolarity = randGen.nextInt((4 - 0) + 1) + 0;
			currentTweet = tweets.get(i);
			currentTweet.setPolarity(randPolarity);
			tweets.add(currentTweet);
			i++;
		}
		
		return tweets;
	}
	
	public void writePredictedFile(ArrayList<Tweet> tweets, String fileName) {
		try {
			FileWriter writer = new FileWriter(fileName, true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			Iterator itr = tweets.iterator();
			Tweet currentTweet = new Tweet(0, " ", " ", " ");
			int i = 0;
			
			while (itr.hasNext()) {
				currentTweet = tweets.get(i);
				bufferedWriter.write(currentTweet.getPolarity());
				bufferedWriter.write(", ");
				bufferedWriter.write(currentTweet.getID());
				bufferedWriter.write(", ");
				bufferedWriter.write(currentTweet.getUser());
				bufferedWriter.write(", ");
				bufferedWriter.write(currentTweet.getTweet());
				bufferedWriter.newLine();
				i++;
			}
		} 
		catch (IOException e) {
			System.out.println("ERROR: IOException thrown!!!");
		}
	}
}
