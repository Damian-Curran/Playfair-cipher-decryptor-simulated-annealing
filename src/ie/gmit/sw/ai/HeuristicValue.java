package ie.gmit.sw.ai;

import java.util.Map;

public class HeuristicValue {
	//method to get heuristic log score of current key
	public static double totalScore(Map<String, Integer> quadgrams, long totalQuadgrams, char[] ks)
	{
		double totalScore = 0;
		int frequency = 0;
		
		//changes passed in char[] array, which is the current decrypted text attempt
		String k = new String(ks);
		
		//loop through text, -4 because we are counting in +4's
		for(int i=0; i< k.length() - 4; i++){
			//check if 4grams.txt contains current read quadgram from decrypted text
			if(quadgrams.get(k.substring(i, i+4)) != null){
				//frequency of quadgram in 4grams.txt
				frequency = quadgrams.get(k.substring(i, i+4));
			}else{
				//if current uadgram is not found in 4gram.txt
				frequency = 1;
			}
			//get score of occurence/totalgrams and floor the score using log10
			totalScore += Math.log10((double) frequency/totalQuadgrams);
		}
		
		return totalScore;
	}
}
