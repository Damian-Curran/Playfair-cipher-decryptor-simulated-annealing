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
				System.out.println("2%");
			case 9:
			case 10:
				System.out.println("2%");
			default:
				System.out.println("90%");
		}
		return newKey;
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
}
