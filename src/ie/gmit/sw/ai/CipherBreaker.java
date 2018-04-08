package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.IOException;

public class CipherBreaker {
	public static void main(String[] args) throws IOException {
		String content = FileParser.gramReader("cyphertext.txt").readLine();
		BufferedReader input2 = FileParser.gramReader("4grams.txt");
		
		System.out.println(content);
		System.out.println(input2.readLine());
	}
}
