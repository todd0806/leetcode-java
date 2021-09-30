package medium.q221_MaximalSquare;

/**
 * @author Todd https://leetcode.com/problems/maximal-square/
 */
public class Solution {

	/**
	 * DP
	 * 圖：https://leetcode-cn.com/problems/maximal-square/solution/zui-zhi-wen-ti-jiu-ying-gai-xiang-dao-do-j1js/
	 * code：https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-dong-tai-gui-hua-uek62/
	 * @param matrix
	 * @return
	 */
	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m + 1][n + 1];
		int max = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max * max;
	}
}
