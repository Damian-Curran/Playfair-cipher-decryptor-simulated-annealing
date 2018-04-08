package ie.gmit.sw.ai;

public class Key {
	public static char[] alterKey(char[] newKey) {
		switch((int)(Math.random()*100)) {
			case 1:
			case 2:
				return(keyReverse(newKey));
			case 3:
			case 4:
				System.out.println("2%");
			case 5:
			case 6:
				System.out.println("2%");
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
}
