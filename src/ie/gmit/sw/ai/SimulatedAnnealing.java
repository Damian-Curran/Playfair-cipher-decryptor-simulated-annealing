package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SimulatedAnnealing {
	private static char[] parent = null;
	
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
		double maxScore, bestScore;
		long totalQuadgrams = quadgrams.values().stream().mapToLong(i->i).sum();
		
		k = Decryptor.decipher(r, k, child);
		
		maxScore = HeuristicValue.totalScore(quadgrams, totalQuadgrams, k);
		
		bestScore = maxScore;
	}
}
