package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class CipherBreaker {
	public static void main(String[] args) throws IOException {
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		String fname = "";
		String content = "";
		
		while(exit == false)
		{
			System.out.println("===============Menu==============");
		    System.out.println("Select one of the following options below");
		    System.out.println("1: Enter text file name to decrypt");
		    System.out.println("2: Exit");
			
		    int choice = scanner.nextInt();
		    
		    switch (choice) {
		        case 1:
		        	while(content.equals(""))
		        	{
		        		System.out.print("Name: ");
			            fname = scanner.next();
			            fname += ".txt";
			            
			            try{
			            	content = FileParser.gramReader(fname).readLine();
			            }catch(java.io.FileNotFoundException name){
			            	System.out.println("File not found, please try again");
			            }
			            
		        	}
		            
		            BufferedReader input2 = FileParser.gramReader("4grams.txt");
		    		
		    		String validContent = FileParser.validateText(content);
		    		
		    		char[] r = validContent.toCharArray();
		    		char[] k = validContent.toCharArray();
		    		
		    		SimulatedAnnealing.saStart(r, k, validContent, input2);
		            
		            break;
		        case 2:
		            exit = true;
		            break;
		        default:
		    }
		}

	    scanner.close();
	}
}
