package ie.gmit.sw.ai;

//time complexity of class is O(n) because of for loop in decipher class
//this results in this class's time complexity to O(n)
//space complexity of this class is O(n)

public class Decryptor {
	public static char[] decipher(char[] r, char[] k, char[] child)
	{
		//create variable i which will control for loop
		int i;
		//set len which controls max iterations of for loop
		int len = r.length;
		//variables to store 2 chars from char[] r
		char c1, c2;
		//variables used to calculate index, which row they are in and which column they are in
		int c1_ind, c2_ind, c1_row, c1_col, c2_row, c2_col;

		//for loop to iterate through r and set k with new characters 
		for (i = 0; i < len; i += 2) {
			//gets 2 characters from r[]
			c1 = r[i];
			c2 = r[i + 1];
			
			//get index of characters in child key
			c1_ind = (int)(new String(child).indexOf(c1));
			c2_ind = (int)(new String(child).indexOf(c2));

			//get rows and cols that characters are in
			c1_row = c1_ind / 5;
			c2_row = c2_ind / 5;
			c1_col = c1_ind % 5;
			c2_col = c2_ind % 5;
			
			//rule 2, letters in same row
			if (c1_row == c2_row) { 
				if (c1_col == 0) {
					k[i] = child[c1_ind + 4];
					k[i+1] = child[c2_ind - 1];
				} else if (c2_col == 0 ) {
					k[i] = child[c1_ind - 1];
					k[i+1] = child[c2_ind + 4];
				} else {
					k[i] = child[c1_ind - 1];
					k[i+1] = child[c2_ind - 1];
				}
			}//rule 3, letters in same columns
			else if (c1_col == c2_col ) {
				if (c1_row == 0) {
					k[i] = child[c1_ind + 20];
					k[i+1] = child[c2_ind - 5];
				} else if (c2_row == 0) {
					k[i] = child[c1_ind - 5];
					k[i+1] = child[c2_ind + 20];
				} else {
					k[i] = child[c1_ind - 5];
					k[i+1] = child[c2_ind - 5];
				}
			}
			else {//rule 1, letters in different rows and columns
				k[i] = child[5 * c1_row + c2_col];
				k[i+1] = child[5 * c2_row + c1_col];
			}
		}
		//returns altered text in the form of char[] k
		return k;
	}
}
