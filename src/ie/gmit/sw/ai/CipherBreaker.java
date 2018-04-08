package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.IOException;

public class CipherBreaker {
	public static void main(String[] args) throws IOException {
		String content = FileParser.gramReader("cyphertext.txt").readLine();
		
		System.out.println(content);
	}
}
