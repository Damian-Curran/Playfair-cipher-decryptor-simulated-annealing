package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class SimulatedAnnealing {
	private static SecureRandom rand;
	private static char[] parent = null;
	
	public static void saStart(char[] r, char[] k, String content, BufferedReader input2) throws IOException
	{
		String stringKey = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
		parent = stringKey.toCharArray();
		
		System.out.println(parent);
		
		Map<String, Integer> quadgrams = new HashMap<String, Integer>();
	}
}
