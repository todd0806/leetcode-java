package medium.q200_NumberofIslands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Todd https://leetcode.com/problems/number-of-islands/
 */
public class Solution {
	/**
	 * https://leetcode-cn.com/problems/number-of-islands/solution/number-of-islands-shen-du-you-xian-bian-li-dfs-or-/
	 * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
	 * DFS
	 * @param grid
	 * @return
	 *  m == grid.length      row
		n == grid[i].length   column
		1 <= m, n <= 300
	 */
	public int numIslands(char[][] grid) {
		int count = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == '1') {
					// dfs比較快
					dfs(i, j, grid);
//					bfs(i, j, grid);
					count++;
				}
			}
		}
		return count;
	}
	
	private void dfs(int i, int j, char[][] grid) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}
		// 標記遍歷過
		grid[i][j] = '0';
		dfs(i - 1, j, grid);
		dfs(i + 1, j, grid);
		dfs(i, j - 1, grid);
		dfs(i, j + 1, grid);
	}
	
//	private void bfs(int i, int j, char[][] grid) {
//		Queue<int[]> queue = new LinkedList<>();
//		queue.add(new int[] {i, j});
//		while(!queue.isEmpty()) {
//			int[] location = queue.poll();
//			i = location[0];
//			j = location[1];
//			if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
//				grid[i][j] = '0';
//				queue.add(new int[] {i + 1, j});
//				queue.add(new int[] {i - 1, j});
//				queue.add(new int[] {i, j + 1});
//				queue.add(new int[] {i, j - 1});
//			}
//		}
//	}
}
