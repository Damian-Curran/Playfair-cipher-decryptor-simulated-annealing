package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class SimulatedAnnealing {
	//class variable parent which holds the current best key
	private static char[] parent = null;
	//create rand to be used later
	private static SecureRandom rand;
	
	//method which is called to start the SA process
	public static void saStart(char[] r, char[] k, String content, BufferedReader input2) throws IOException
	{
		//string of all valid letters of the alphabet(-j)
		String stringKey = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
		//temperature 
		double temp;
		//sets alphabet to char array
		char[] randomKey = stringKey.toCharArray();
		//randomly shuffles the 25 characters
		randomKey = Key.keyShuffle(randomKey);
		
		//set parent as newly generated random key
		parent = randomKey;
		
		//to store from 4grams.txt
		Map<String, Integer> quadgrams = new HashMap<String, Integer>();
		
		//calls method to read all quadgrams(quadgram and relative int total occurence)
		quadgrams = QuadGrams.readQuadgrams(input2);
		
		//calculates temperate for current encrypted file
		temp = ((content.length()/100)*1.8)+40;
		
		//calls SA and passes needed variables
		SimulatedAnnealing.simulatedAnnealing(r, k, content, quadgrams, temp);
	}
	
	//method where most of the work is done
	public static void simulatedAnnealing(char[] r, char[] k, String content, Map<String, Integer> quadgrams, double temp) throws IOException
	{
		//set to be used later
		rand = new SecureRandom();
		//clone parent key to child key
		char[] child = parent.clone();
		//create variables to be used later
		double maxScore, bestScore, score, diff, prob;
		//set transitions to 50000, controls for-loop
		int transitions = 50000;
		int count = 0, iter = 0;
		//gets total of all quadgram ints from 4grams.txt
		long totalQuadgrams = quadgrams.values().stream().mapToLong(i->i).sum();
		//set bestText to empty
		String bestText = "";
		
		//decrypts text using current key
		k = Decryptor.decipher(r, k, child);
		
		//sets initial maxScore to the first scored key
		maxScore = HeuristicValue.totalScore(quadgrams, totalQuadgrams, k);
		
		//sets best as max
		bestScore = maxScore;
		
		//temp loop which controls the probability of taking a bad key
		for(double i = temp; i > 0; i -= 1)
		{
			for(count = transitions; count > 0; count--)
			{
				//set k back to original read in text each loop
				k = content.toCharArray();
				//clone parent key to child(copies over best key)
				child = parent.clone();
				
				//alters child key
				Key.alterKey(child);
				
				//decrypts with new key
				k = Decryptor.decipher(r, k, child);
				
				//scores the key
				score = HeuristicValue.totalScore(quadgrams, totalQuadgrams, k);
				
				//gets the difference between maxscore and current key score
				diff = score - maxScore;
				
				//if diff is positive, new best key
				if(diff > 0){
					maxScore = score;
					parent = child.clone();
				}
				else if(count > 0){
					//porbability which can take worse keys
					//becomes less likely for each iteration of the temp loop
					prob = Math.exp((diff / i));
					if(prob > rand.nextDouble()){
						maxScore = score;
						parent = child.clone();
					}
				}
				
				//if new best score found, output stats 
				if (maxScore > bestScore){
					bestScore = maxScore;
					bestText = k.toString();
					
					System.out.println("iteration: " + iter);
					System.out.println("new bestScore using key " + new String(child));
					System.out.println("new bestScore " + bestScore);
					System.out.println("new text " + new String(k));
					System.out.println();
				}
				//keeps track of what iteration the loop is on
				iter++;
			}
		}
		FileParser.output(bestText);
	}
}
