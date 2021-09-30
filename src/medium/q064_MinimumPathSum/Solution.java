package medium.q064_MinimumPathSum;

/**
 * @author Todd
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class Solution {
	/**https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
	 * @param grid
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(i == 0 && j == 0) {
					continue;
				}
				if(i == 0 && j != 0) {
					grid[i][j] = grid[i][j - 1] + grid[i][j];
				}else if(i != 0 && j == 0) {
					grid[i][j] = grid[i - 1][j] + grid[i][j];
				}else {
					grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
				}
			}
		}
		return grid[grid.length - 1][grid[0].length - 1];
	}
}
