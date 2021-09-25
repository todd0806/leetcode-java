package medium.q120_Triangle;

import java.util.List;

/**
 * @author Todd
 * https://leetcode.com/problems/triangle/description/
 */
public class Solution {
	
	/**https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
	 * @param triangle
	 * @return
	 */

	
	/**DP
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] dp = new int[n + 1][n + 1];
		
		for(int i = n - 1; i >= 0; i--) {
			for(int j = 0; j < triangle.get(i).size(); j++) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
			}
		}
		return dp[0][0];
	}
	
	
	/**DFS + 緩存
	 * @param triangle
	 * @return
	 */
//	private Integer[][] temp;
//	public int minimumTotal(List<List<Integer>> triangle) {
//		temp = new Integer[triangle.size()][triangle.size()];
//		return dfs(triangle, 0, 0);
//	}
//	
//	private int dfs(List<List<Integer>> triangle, int i, int j) {
//		if(triangle.size() == i) {
//			return 0;
//		}
//		
//		if(temp[i][j] != null) {
//			return temp[i][j];
//		}
//		
//		temp[i][j] = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j); 
//		
//		return temp[i][j];
//	}
		
	
	// 逾時
//	public int minimumTotal(List<List<Integer>> triangle) {
//		return dfs(triangle, 0, 0);
//	}
//	
//	private int dfs(List<List<Integer>> triangle, int i, int j) {
//		if(triangle.size() == i) {
//			return 0;
//		}
//		
//		return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
//	}
}
