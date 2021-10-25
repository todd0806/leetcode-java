package medium.q059_SpiralMatrixII;


// https://leetcode.com/problems/spiral-matrix-ii/

public class Solution {
	// https://leetcode.com/problems/spiral-matrix-ii/discuss/1383545/Simple-Java-0ms-solution-with-Explanation
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];

		int colStart = 0;
		int colEnd = n - 1;
		int rowStart = 0;
		int rowEnd = n - 1;
		int value = 1;

		while (value <= n * n) {

			// left to right
			for (int i = colStart; i <= colEnd; i++) {
				matrix[rowStart][i] = value++;
			}
			rowStart++;

			// top to bottom
			for (int j = rowStart; j <= rowEnd; j++) {
				matrix[j][colEnd] = value++;
			}
			colEnd--;

			// right to left
			for (int i = colEnd; i >= colStart; i--) {
				matrix[rowEnd][i] = value++;
			}
			rowEnd--;

			// bottom to top
			for (int j = rowEnd; j >= rowStart; j--) {
				matrix[j][colStart] = value++;
			}
			colStart++;

		}
		return matrix;
	}
}
