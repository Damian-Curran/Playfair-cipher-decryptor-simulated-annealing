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
			}
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
			else {
				k[i] = child[5 * c1_row + c2_col];
				k[i+1] = child[5 * c2_row + c1_col];
			}
		}
		return k;
	}
}
