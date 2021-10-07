package medium.q1091_ShortestPathinBinaryMatrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Todd https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */
public class Solution {

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 0, 1 }, { 1, 0 } };
		System.out.print(new Solution().shortestPathBinaryMatrix(grid));
	}

	/**
	 * https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/solution/jian-dan-yi-dong-de-bfs-by-qiu-yu-mei-xu-kzq1/
	 * 
	 * @param grid
	 * @return
	 */
	public int shortestPathBinaryMatrix(int[][] grid) {
		if(grid[0][0] == 1) {
			return -1;
		}
		int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
		int[] dy = {1, 0, -1, -1, -1, 0, 1, 1};
		int row = grid.length;
		int col = grid[0].length;
		int count = 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0, 0});
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int c = 0; c < size; c++) {
				int[] now = queue.poll();
				int x = now[0];
				int y = now[1];
				if(x == row - 1 && y == col - 1) {
					return count;
				}
				for(int i = 0; i < dx.length; i++) {
					if(x + dx[i] >= row || x + dx[i] < 0 || y + dy[i] >= col || y + dy[i] < 0 || grid[x + dx[i]][y + dx[i]] == 1) {
						continue;
					}
					queue.add(new int[] {x + dx[i], y + dy[i]});
					grid[x + dx[i]][y + dy[i]] = 1;
				}
			}
			count++;
		}
		return 0;
	}

	// 雙端BFS
	// https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/solution/shuang-duan-bfsdui-pu-tong-bfsshao-zuo-x-9pyf/
	// 八个方向
//	int[] dx = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };
//	int[] dy = new int[] { 1, 1, 1, 0, -1, -1, -1, 0 };
//	int n = 0;
//	// 记录答案步数， 因为从起点和终点同时开始，初始是2步。
//	int ans = 2;
//
//	// 双向bfs
//	public int shortestPathBinaryMatrix(int[][] grid) {
//		n = grid[0].length; // 矩阵大小
//		if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
//			return -1;
//		if (n == 1 && grid[0][0] == 0)
//			return 1;
//		// 起点队列和终点队列同时开始，所以要双队列
//		Queue<int[]> qStart = new LinkedList<>();
//		Queue<int[]> qEnd = new LinkedList<>();
//		// 分别记录起点和终点已经访问过的节点，如果发现另外一个已经访问了，说明能够结束BFS了。
//		int[][] visitedS = new int[n][n];
//		int[][] visitedE = new int[n][n];
//		qStart.offer(new int[] { 0, 0 });
//		qEnd.offer(new int[] { n - 1, n - 1 });
//		visitedS[0][0] = 1;
//		visitedE[n - 1][n - 1] = 1;
//
//		// 双向bfs，每次循环，起点和终点各前进一层，碰头结束。
//		while (!qStart.isEmpty() || !qEnd.isEmpty()) {
//			boolean res = expand(qStart, grid, visitedS, visitedE);
//			if (res)
//				return ans;
//			res = expand(qEnd, grid, visitedE, visitedS);
//			if (res)
//				return ans;
//		}
//		return -1;
//
//	}
//
//	// 这是典型的BFS逻辑，区别就是while改为if， 和判断结束条件需要修改
//	private boolean expand(Queue<int[]> queue, int[][] grid, int[][] visited, int[][] visitedOther) {
//		if (!queue.isEmpty()) {// while改为if
//			int size = queue.size();
//
//			for (int i = 0; i < size; i++) {
//				int[] curr = queue.poll();
//				int x = curr[0];
//				int y = curr[1];
//				for (int j = 0; j < 8; j++) {
//					int nextx = curr[0] + dx[j];
//					int nexty = curr[1] + dy[j];
//					if (nextx >= n || nextx < 0 || nexty >= n || nexty < 0 || visited[nextx][nexty] == 1
//							|| grid[nextx][nexty] == 1)
//						continue;
//					if (visitedOther[nextx][nexty] == 1)
//						return true;// 如果另外的队列已经访问过，说明最短路径有解，返回.
//					visited[nextx][nexty] = 1;
//					queue.offer(new int[] { nextx, nexty });
//				}
//
//			}
//			// 每一层循环结束，步数+1
//			ans++;
//		}
//		return false;
//	}

}
