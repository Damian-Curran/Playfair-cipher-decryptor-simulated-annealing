package ie.gmit.sw.ai;

public class Decryptor {
	public static char[] decipher(char[] r, char[] k, char[] child)
	{
		int i;
		int len = r.length;
		char c1, c2;
		int c1_ind, c2_ind, c1_row, c1_col, c2_row, c2_col;

		for (i = 0; i < len; i += 2) {
			c1 = r[i];
			c2 = r[i + 1];
			
			c1_ind = (int)(new String(child).indexOf(c1));
			c2_ind = (int)(new String(child).indexOf(c2));

			c1_row = c1_ind / 5;
			c2_row = c2_ind / 5;
			c1_col = c1_ind % 5;
			c2_col = c2_ind % 5;
		}
		return k;
	}
}
