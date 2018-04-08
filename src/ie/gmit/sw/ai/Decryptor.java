package ie.gmit.sw.ai;

public class Decryptor {
	public static char[] decipher(char[] r, char[] k, char[] child)
	{
		int i;
		int len = r.length;
		char c1, c2;
		int c1_ind, c2_ind;

		for (i = 0; i < len; i += 2) {
			c1 = r[i];
			c2 = r[i + 1];
			
			c1_ind = (int)(new String(child).indexOf(c1));
			c2_ind = (int)(new String(child).indexOf(c2));

			System.out.println(c1_ind + " " + c2_ind);
		}
		return k;
	}
}
