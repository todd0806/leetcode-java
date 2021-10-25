package medium.q695_MaxAreaofIsland;
// https://leetcode.com/problems/max-area-of-island/
public class Solution {
	public int maxAreaOfIsland(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, dfs(grid, i, j));
			}
		}

		return max;
	}

	private Integer dfs(int[][] grid, int row, int col) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
			return 0;
		}

		grid[row][col] = 0;
		int ans = 1;
		ans += dfs(grid, row + 1, col);
		ans += dfs(grid, row - 1, col);
		ans += dfs(grid, row, col + 1);
		ans += dfs(grid, row, col - 1);
		return ans;
	}

}
