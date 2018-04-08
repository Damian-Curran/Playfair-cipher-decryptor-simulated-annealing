package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class SimulatedAnnealing {
	private static char[] parent = null;
	private static SecureRandom rand;
	
	public static void saStart(char[] r, char[] k, String content, BufferedReader input2) throws IOException
	{
		String stringKey = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
		double temp;
		parent = stringKey.toCharArray();
		
		Map<String, Integer> quadgrams = new HashMap<String, Integer>();
		
		quadgrams = QuadGrams.readQuadgrams(input2);
		
		temp = ((content.length()/100)*1.8)+40;
		
		SimulatedAnnealing.simulatedAnnealing(r, k, content, quadgrams, temp);
	}
	
	public static void simulatedAnnealing(char[] r, char[] k, String content, Map<String, Integer> quadgrams, double temp)
	{
		char[] child = parent.clone();
		double maxScore, bestScore, score, diff, prob;
		int transitions = 50000;
		int count = 0;
		long totalQuadgrams = quadgrams.values().stream().mapToLong(i->i).sum();
		
		k = Decryptor.decipher(r, k, child);
		
		maxScore = HeuristicValue.totalScore(quadgrams, totalQuadgrams, k);
		
		bestScore = maxScore;
		
		for(double i = temp; i > 0; i -= 1)
		{
			for(count = transitions; count > 0; count--)
			{
				k = content.toCharArray();
				child = parent.clone();
				
				Key.alterKey(child);
				
				k = Decryptor.decipher(r, k, child);
				
				score = HeuristicValue.totalScore(quadgrams, totalQuadgrams, k);
				
				diff = score - maxScore;
				
				if(diff > 0){
					maxScore = score;
					parent = child.clone();
				}
				else if(count > 0){
					prob = Math.exp((diff / i));
					if(prob > rand.nextDouble()){
						maxScore = score;
						parent = child.clone();
					}
				}
			}
		}
	}
}
