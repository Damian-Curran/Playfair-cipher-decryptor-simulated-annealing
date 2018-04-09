package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class CipherBreaker {
	public static void main(String[] args) throws IOException {
		//variables needed for for reading text and looping
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		String fname = "";
		String content = "";
		
		while(exit == false)
		{
			//command console user menu
			System.out.println("===============Menu==============");
		    System.out.println("Select one of the following options below");
		    System.out.println("1: Enter text file name to decrypt");
		    System.out.println("2: Exit");
			
		    //takes the next int the user enters
		    int choice = scanner.nextInt();
		    
		    //a switch that acts on user int entered
		    switch (choice) {
		        case 1:
		        	//while the file is not found or is empty
		        	while(content.equals(""))
		        	{
		        		//ask user for file name
		        		System.out.print("Name: ");
			            fname = scanner.next();
			            fname += ".txt";
			            
			            //try to read file and catch not found error
			            try{
			            	content = FileParser.gramReader(fname).readLine();
			            }catch(java.io.FileNotFoundException name){
			            	System.out.println("File not found, please try again");
			            }
			            
		        	}
		            
		        	//reads 4grams.txt into bufferedReader
		            BufferedReader input2 = FileParser.gramReader("4grams.txt");
		    		
		            //calls validation on the encrypted file taken as input above
		    		String validContent = FileParser.validateText(content);
		    		
		    		//set char array to the validated encrypted text
		    		char[] r = validContent.toCharArray();
		    		char[] k = validContent.toCharArray();
		    		
		    		//start the simulated annealing process
		    		SimulatedAnnealing.saStart(r, k, validContent, input2);
		            
		            break;
		        case 2:
		            exit = true;
		            break;
		        default:
		    }
		    //sets fname back to empty string
		    fname = "";
		    //sets content of file to empty string
		    content = "";
		}

	    scanner.close();
	}
}
