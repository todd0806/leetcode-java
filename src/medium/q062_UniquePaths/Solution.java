package medium.q062_UniquePaths;

/**
 * @author Todd https://leetcode.com/problems/unique-paths/
 */
public class Solution {

//		https://leetcode-cn.com/problems/unique-paths/solution/dai-ma-sui-xiang-lu-dong-gui-wu-bu-qu-xi-1vkb/
//		https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-jian-dan-yi-dong-by-ccp-xe1d/

	// 僅需一維儲存空間
	public int uniquePaths(int m, int n) {
		int[] dp = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					dp[j] = 1;
					continue;
				}
				dp[j] += dp[j - 1];
			}
		}
		return dp[n - 1];
	}

	/**
	 * 二維儲存空間
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
//	public int uniquePaths(int m, int n) {
//		int[][] dp = new int[m][n];
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				if (i == 0 || j == 0) {
//					dp[i][j] = 1;
//					continue;
//				}
//
//				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//			}
//		}
//		return dp[m - 1][n - 1];
//
//	}
}
