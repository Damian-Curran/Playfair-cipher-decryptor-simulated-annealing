package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
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
		char[] temp = content.toUpperCase().toCharArray();
		
		System.out.println(temp.length);
		
		for (int i = 0; i < temp.length - 1; i+=2) {
			if (temp[i] == temp[i+1]) {
				valText2 += temp[i];
				valText2 += "X";
			}
			else{
				valText2 += temp[i];
				valText2 += temp[i+1];
			}
		}
		
		if(valText2.length() % 2 == 1)
		{
			valText2 += "X";
		}
		
		return valText2;
	}
}
