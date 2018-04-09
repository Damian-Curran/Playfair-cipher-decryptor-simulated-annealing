package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//time complexity validateText is O(n)
//this results in this class's time complexity to O(n)
//space complexity of this class is O(n) from the array in validateText

public class FileParser {
	//parsing files method
	public static BufferedReader gramReader(String string) throws IOException
	{
		File file = new File(string);
		FileReader fr = new FileReader(file);
		BufferedReader input = new BufferedReader(fr);
		
		return input;
	}
	
	public static String validateText(String content)
	{
		String valText2 = "";
		//makes everything in the text file uppercase
		char[] temp = content.toUpperCase().toCharArray();
		
		//loops through text to check for duplicate characters
		for (int i = 0; i < temp.length - 1; i+=2) {
			if (temp[i] == temp[i+1]) {
				valText2 += temp[i];
				//if duplicates found, replace second character with a 'X'
				valText2 += "X";
			}
			else{
				//if no duplicates, add read characters to string
				valText2 += temp[i];
				valText2 += temp[i+1];
			}
		}
		
		//checks if text file has an even amount of characters
		if(valText2.length() % 2 == 1)
		{
			//if text file count uneven, add a 'X' at the end
			valText2 += "X";
		}
		
		return valText2;
	}
	
	//method which outputs the decrypted text associated with the heuristic value
	public static void output(String text) throws IOException
	{
		System.out.println(text);
		//prints output to results.txt file
		BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter("result.txt"), text.length());
		
		bufferedWriter.write(text);
		
		//close bufferedWriter
		bufferedWriter.close();
	}
}
