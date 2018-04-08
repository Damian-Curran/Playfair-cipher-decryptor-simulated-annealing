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
}
