package medium.q063_UniquePathsII;

/**
 * @author Todd https://leetcode.com/problems/unique-paths-ii/
 */
public class Solution {
	
	public static void main(String[] args) {
		new Solution().uniquePathsWithObstacles(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
	}
	
	/**https://leetcode-cn.com/problems/unique-paths-ii/solution/bu-tong-lu-jing-iijava-by-sui-ji-guo-che-mg7q/
	 * @param obstacleGrid
	 * @return
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		for(int i = 0; i < m && obstacleGrid[i][0] != 1; i++) {
			dp[i][0] = 1;
		}
		for(int j = 0; j < n && obstacleGrid[0][j] != 1; j++) {
			dp[0][j] = 1;
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(obstacleGrid[i][j] == 1) {
					continue;
				}
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m-1][n-1];
	}

}
