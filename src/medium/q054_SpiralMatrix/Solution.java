package medium.q054_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
public class Solution {
	// https://leetcode.com/problems/spiral-matrix/discuss/1459284/JAVA-0ms-or-100-faster-or-Easy-to-understand-solution
	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> ans = new ArrayList<>();

		int minr = 0, minc = 0, maxr = matrix.length - 1, maxc = matrix[0].length - 1;
		int t = matrix.length * matrix[0].length, count = 0;

		while (count < t) {

			for (int r = minr, c = minc; c <= maxc && count < t; c++) {
				ans.add(matrix[r][c]);
				count++;
			}
			minr++;

			for (int r = minr, c = maxc; r <= maxr && count < t; r++) {
				ans.add(matrix[r][c]);
				count++;
			}
			maxc--;

			for (int r = maxr, c = maxc; c >= minc && count < t; c--) {
				ans.add(matrix[r][c]);
				count++;
			}
			maxr--;

			for (int r = maxr, c = minc; r >= minr && count < t; r--) {
				ans.add(matrix[r][c]);
				count++;
			}
			minc++;

		}
		return ans;
	}
}
