package ie.gmit.sw.ai;

public class Key {
	public static char[] alterKey(char[] newKey) {
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
	
	public static char[] keyReverse(char[] newKey) {	
		String tempKey = new String(newKey);
		
		String key = new StringBuilder(tempKey).reverse().toString();
		
		newKey = key.toCharArray();
		
		return newKey;
	}
	
	public static char[] keySwapRows(char[] newKey, int r1, int r2) {
		int i;
		char temp;
		
		for (i = 0; i < 5; i++) {
			temp = newKey[r1 * 5 + i];
			newKey[r1 * 5 + i] = newKey[r2 * 5 + i];
			newKey[r2 * 5 + i] = temp;
		}
		
		return newKey;
	}
	
	public static char[] keySwapCols(char[] newKey, int c1, int c2) {
		int i;
		char temp;
		for (i = 0; i < 5; i++) {
			temp = newKey[i * 5 + c1];
			newKey[i * 5 + c1] = newKey[i * 5 + c2];
			newKey[i * 5 + c2] = temp;
		}
		
		return newKey;
	}
	
	public static char[] keySwapChars(char[] newKey, int i1, int i2) {	
		char temp = newKey[i1];
		newKey[i1] = newKey[i2];
		newKey[i2] = temp;
		
		return newKey;
	}
	
	public static char[] keyFlipRows(char[] newKey) {
		int i;
		char temp;
		int l = -1;
		
		for(int j = 4; j > 2; j--)
		{
			l++;
			for (i = 0; i < 5; i++) {
				temp = newKey[l * 5 + i];
				newKey[l * 5 + i] = newKey[j * 5 + i];
				newKey[j * 5 + i] = temp;
			}
		}
		
		return newKey;
	}
	
	public static char[] keyFlipCols(char[] newKey) {
		int i;
		char temp;
		int l = -1;
		
		for(int j = 4; j > 2; j--)
		{
			l++;
			for (i = 0; i < 5; i++) {
				temp = newKey[i * 5 + l];
				newKey[i * 5 + l] = newKey[i * 5 + j];
				newKey[i * 5 + j] = temp;
			}
		}
		
		return newKey;
	}
	
	public static char[] keyShuffle(char[] newKey) {
		int i;
		for (i = 0; i < 25; i++) {
			keySwapChars(newKey, (int)Math.random() * 25, (int)Math.random() * 25);
		}
		
		return newKey;
	}
}
