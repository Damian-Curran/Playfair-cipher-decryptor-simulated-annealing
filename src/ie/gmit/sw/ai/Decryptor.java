package ie.gmit.sw.ai;

public class Decryptor {
	public static char[] decipher(char[] r, char[] k, char[] child)
	{
		int i;
		int len = r.length;
		char c1, c2;

		for (i = 0; i < len; i += 2) {
			c1 = r[i];
			c2 = r[i + 1];

			System.out.println(c1 + " " + c2);
		}
		return k;
	}
}
