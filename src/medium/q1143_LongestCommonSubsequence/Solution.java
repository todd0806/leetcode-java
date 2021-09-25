package medium.q1143_LongestCommonSubsequence;

/**
 * @author Todd 
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class Solution {

	/**https://leetcode-cn.com/problems/longest-common-subsequence/solution/1143-zui-chang-gong-gong-zi-xu-lie-by-ming-zhi-sha/
	 * @param text1
	 * @param text2
	 * @return
	 */
	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int[][] dp = new int[m+1][n+1];
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}
}
