package medium.q547NumberofProvinces;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Todd
 * https://leetcode.com/problems/number-of-provinces/
 * 並查集
 */
public class Solution {
	
	/**並查集
	 * https://leetcode-cn.com/problems/number-of-provinces/solution/python-duo-tu-xiang-jie-bing-cha-ji-by-m-vjdr/
	 * @param isConnected
	 * @return
	 */
	class UnionField{
		private HashMap<Integer, Integer> father;
		private int numberOfSet;
		public UnionField() {
			father = new HashMap<Integer, Integer>();
			numberOfSet = 0;
		}
		
		public void add(int x) {
			if(father.get(x) == null) {
				father.put(x, null);
				numberOfSet++;
			}
		}
		
		public int find(int x) {
			int root = x;
			while(father.get(root) != null) {
				root = father.get(root);
			}
			
			while(x != root) {
				int originalParent = father.get(x);
				father.put(x, root);
				x = originalParent;
			}
			
			return root;
		}
		
		public void merge(int x, int y) {
			int X = find(x);
			int Y = find(y);
			if(X != Y) {
				father.put(X, Y);
				numberOfSet--;
			}
		}
		
		public boolean isConnected(int x, int y) {
			return find(x) == find(y);
		}
		
		public int getNumberOfSet() {
			return numberOfSet;
		}
	}
	
	
	public int findCircleNum(int[][] isConnected) {
		UnionField ufd = new UnionField();
		for(int i = 0; i < isConnected.length; i++) {
			ufd.add(i);
			// j的邊界不太懂…
			for(int j = 0; j < i; j++) {
				if(isConnected[i][j] == 1) {
					ufd.merge(i, j);
				}
			}
		}
		return ufd.getNumberOfSet();
	}
	
	/**DFS
	 * https://leetcode-cn.com/problems/number-of-provinces/solution/dfs-bfs-bing-cha-ji-3-chong-fang-fa-ji-s-edkl/
	 * @param isConnected
	 * @return
	 */
//	public int findCircleNum(int[][] isConnected) {
//		int count = 0;
//		int n = isConnected.length;
//		boolean[] isVisited = new boolean[n];
//		
//		for(int i = 0; i < n; i++) {
//			if(isVisited[i] == false) {
//				dfs(isConnected, i, isVisited);
//				count++;
//			}
//		}
//		return count;
//	}
//	
//	private void dfs(int[][] isConnected, int i, boolean[] isVisited) {
//		isVisited[i] = true;
//		for(int j = 0; j < isConnected.length; j++) {
//			if(isConnected[i][j] == 1 && isVisited[j] == false) {
//				dfs(isConnected, j, isVisited);
//			}
//		}
//	}

	/**BFS
	 * https://leetcode-cn.com/problems/number-of-provinces/solution/dfs-bfs-bing-cha-ji-3-chong-fang-fa-ji-s-edkl/
	 * @param isConnected
	 * @return
	 */
//	public int findCircleNum(int[][] isConnected) {
//		int count = 0;
//		int n = isConnected.length;
//		boolean[] visited = new boolean[n];
//		Queue<Integer> queue = new LinkedList<Integer>();
//		for(int i = 0; i < n; i++) {
//			if(visited[i] == false) {
//				count++;
//				queue.add(i);
//				while(!queue.isEmpty()) {
//					int v = queue.poll();
//					for(int w = 0; w < n; w++) {
//						if(isConnected[v][w] == 1 && visited[w] == false) {
//							visited[w] = true;
//							queue.add(w);
//						}
//					}
//				}
//			}
//		}
//		return count;
//	}
}
