package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QuadGrams {
	//method to assign 4grams.txt contents to Map<String, Integer>
	public static Map<String, Integer> readQuadgrams(BufferedReader input2) throws IOException
	{
		Map<String, Integer> quadgrams = new HashMap<String, Integer>();
		
		int total = 0;
		String add = "";
		
		//loop until end of file
		for(int i = 0; i < 389373; i++)
		{
			String values = input2.readLine();
			//add # to create an end point to the line
			values += "#";
			//get first 4 characters of each line
			String gram = "" + values.charAt(0) + values.charAt(1) + values.charAt(2) + values.charAt(3);
			int j = 5;
			total = 0;
			add = "";
			//adds character which is an int postion to a string
			while(values.charAt(j) != '#')
			{
				add += values.charAt(j);
				j++;
			}
			//convert the string of an integer number to an int, total
			total = Integer.parseInt(add);
			//put quadgram and occurence of quadgram into map
			quadgrams.put(gram, total);
		}
		
		return quadgrams;
	}
	
}
