package medium.q048_RotateImage;
// https://leetcode.com/problems/rotate-image/
public class Solution {

	// https://leetcode.com/problems/rotate-image/discuss/19098/A-Simple-and-In-Place-Solution-in-Java
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		// symmetric
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// horizontal
		for (int i = 0; i < n; i++) {
			int left = 0;
			int right = n - 1;
			while (left < right) {
				int temp = matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right] = temp;
				left++;
				right--;
			}
		}
	}

}
