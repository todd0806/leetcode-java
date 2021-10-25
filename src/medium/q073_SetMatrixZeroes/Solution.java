package medium.q073_SetMatrixZeroes;

public class Solution {
	public void setZeroes(int[][] matrix) {

		int[] row = new int[matrix.length];
		int[] col = new int[matrix[0].length];
		int i = 0, j = 0;

		/**
		 * Mark which row and column you want to make zero Don't try to do it
		 * recursively at the same time otherwise you will endup making every thing 0
		 * like a ripple effect You can optimize this but i have taken a rather simple
		 * to understand approach
		 */
		for (i = 0; i < row.length; i++) {
			for (j = 0; j < col.length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1; // this row you have to make 0
					col[j] = 1; // this col you have to make 0
				}
			}
		}

		for (i = 0; i < row.length; i++) {
			if (row[i] == 1) {
				// make this whole row zero
				for (j = 0; j < col.length; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (j = 0; j < col.length; j++) {
			if (col[j] == 1) {
				// make this whole column zero
				for (i = 0; i < row.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
