package project01package;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Tester {
	public static void main() {
		ArrayList<Tweet> myTweets = null;
		Tweets trainingTweets = new Tweets();
		String fileNameTraining = "TrainingTweets.txt";
		
		myTweets = trainingTweets.readFile(fileNameTraining);
		
		Tweet positiveTweet = new Tweet(4, "123456789","gabexdoran", "This project is suuuuuper fun!!!");
		trainingTweets.add(positiveTweet);
		trainingTweets.remove(positiveTweet);
		
		Tweet negativeTweet = new Tweet(0, "987654321", "gabexdoran", "This project reallllyyyy sucks...");
		trainingTweets.add(negativeTweet);
		
		Tweet searchedByID = new Tweet(0, " ", " ", " ");
		searchedByID = trainingTweets.searchByID("123456789");
		System.out.println(searchedByID);
		
		Tweet searchedByUser = new Tweet(0, " ", " ", " ");
		searchedByUser = trainingTweets.searchByUser("gabexdoran");
		System.out.println(searchedByUser);
		
		String[] allIDs = null;
		allIDs = trainingTweets.retriveAllIDs();
		
		for (int i = 0; i < 10; i++) {
			System.out.print(allIDs[i]);
			System.out.print(", ");
		}
		
		ArrayList<Tweet> predictedTweets = null;
		predictedTweets = trainingTweets.predictor(myTweets);
		
		File thisFile = new File("PredictedTweets.txt");
		
		try {
			thisFile.createNewFile();
		} 
		catch (IOException e) {
			System.out.println("ERROR: File not created!!!");
		}
		
		String predictedFileName = null;
		predictedFileName = thisFile.getName();
		
		trainingTweets.writePredictedFile(predictedTweets, predictedFileName);
	}
}
