package ie.gmit.sw.ai;

import java.util.Map;

public class HeuristicValue {
	public static double totalScore(Map<String, Integer> quadgrams, long totalQuadgrams, char[] ks)
	{
		double totalScore = 0;
		int frequency = 0;
		
		String k = new String(ks);
		
		for(int i=0; i< k.length() - 4; i++){
			if(quadgrams.get(k.substring(i, i+4)) != null){
				frequency = quadgrams.get(k.substring(i, i+4));
			}else{
				frequency = 1;
			}
			totalScore += Math.log10((double) frequency/totalQuadgrams);
		}
		
		return totalScore;
	}
}
