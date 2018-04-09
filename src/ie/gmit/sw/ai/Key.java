package ie.gmit.sw.ai;

//time complexity StringBuilder.reverse() is O(n)
//time of looping through arrays in flipCols and flipRows is O(n^2)
//this results in this class's time complexity to O(n^2)
//space complexity of this class is O(n)

public class Key {
	//method that randomizes what changes to apply to the key
	public static char[] alterKey(char[] newKey) {
		//6 chances, 5 have a 2% chance of occuring, the last has 90%
		switch((int)(Math.random()*100)) {
			case 1:
			case 2:
				return(keyReverse(newKey));
			case 3:
			case 4:
				return(keySwapRows(newKey, (int)(Math.random()*5), (int)(Math.random()*5)));
			case 5:
			case 6:
				return(keySwapCols(newKey, (int)(Math.random()*5), (int)(Math.random()*5)));
			case 7:
			case 8:
				return(keyFlipRows(newKey));
			case 9:
			case 10:
				return(keyFlipCols(newKey));
			default:
				return(keySwapChars(newKey, (int)(Math.random()*25), (int)(Math.random()*25)));
		}
	}
	
	//method to reverse key
	public static char[] keyReverse(char[] newKey) {	
		String tempKey = new String(newKey);
		
		//uses stringBuilder to reverse the key
		String key = new StringBuilder(tempKey).reverse().toString();
		
		newKey = key.toCharArray();
		
		return newKey;
	}
	
	//method to swap 2 rows in the key
	public static char[] keySwapRows(char[] newKey, int r1, int r2) {
		int i;
		char temp;
		
		//for loop to change the 5 values
		for (i = 0; i < 5; i++) {
			temp = newKey[r1 * 5 + i];
			newKey[r1 * 5 + i] = newKey[r2 * 5 + i];
			newKey[r2 * 5 + i] = temp;
		}
		
		return newKey;
	}
	
	//method to swap 2 columns in the key
	public static char[] keySwapCols(char[] newKey, int c1, int c2) {
		int i;
		char temp;
		
		//for loop to change the 5 values
		for (i = 0; i < 5; i++) {
			temp = newKey[i * 5 + c1];
			newKey[i * 5 + c1] = newKey[i * 5 + c2];
			newKey[i * 5 + c2] = temp;
		}
		
		return newKey;
	}
	
	//method to swap 2 characters in the key
	public static char[] keySwapChars(char[] newKey, int i1, int i2) {	
		char temp = newKey[i1];
		newKey[i1] = newKey[i2];
		newKey[i2] = temp;
		
		return newKey;
	}
	
	//method to flip all the rows in the key
	public static char[] keyFlipRows(char[] newKey) {
		int i;
		char temp;
		int l = -1;
		
		//j controls the the last 2 rows, last row first iteration, second last in the second iteration
		for(int j = 4; j > 2; j--)
		{
			//l controls the first 2 rows
			l++;
			//i controls the position of each character in the rows
			for (i = 0; i < 5; i++) {
				temp = newKey[l * 5 + i];
				newKey[l * 5 + i] = newKey[j * 5 + i];
				newKey[j * 5 + i] = temp;
			}
		}
		
		return newKey;
	}
	
	//method to flip all the columns in the key
	public static char[] keyFlipCols(char[] newKey) {
		int i;
		char temp;
		int l = -1;
		
		//j controls the the last 2 columns, last column first iteration, second last in the second iteration
		for(int j = 4; j > 2; j--)
		{
			//l controls the first 2 columns
			l++;
			//i controls the position of each character in the columns
			for (i = 0; i < 5; i++) {
				temp = newKey[i * 5 + l];
				newKey[i * 5 + l] = newKey[i * 5 + j];
				newKey[i * 5 + j] = temp;
			}
		}
		
		return newKey;
	}
	
	//method which is used for shuffling a key at the start of the run cycle
	public static char[] keyShuffle(char[] newKey) {
		int i;
		
		for (i = 0; i < 25; i++) {
			newKey = keySwapChars(newKey, (int)(Math.random()*25), (int)(Math.random()*25));
		}
		
		return newKey;
	}
}
