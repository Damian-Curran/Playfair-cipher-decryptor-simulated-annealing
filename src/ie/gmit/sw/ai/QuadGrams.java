package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QuadGrams {
	public static Map<String, Integer> readQuadgrams(BufferedReader input2) throws IOException
	{
		Map<String, Integer> quadgrams = new HashMap<String, Integer>();
		
		int total = 0;
		String add = "";
		
		for(int i = 0; i < 389373; i++)
		{
			String values = input2.readLine();
			values += "#";
			String gram = "" + values.charAt(0) + values.charAt(1) + values.charAt(2) + values.charAt(3);
			int j = 5;
			total = 0;
			add = "";
			while(values.charAt(j) != '#')
			{
				add += values.charAt(j);
				j++;
			}
			total = Integer.parseInt(add);
			quadgrams.put(gram, total);
		}
		
		return quadgrams;
	}
	
}
