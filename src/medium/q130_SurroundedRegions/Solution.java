package medium.q130_SurroundedRegions;

/**
 * @author Todd
 * https://leetcode.com/problems/surrounded-regions/
 */
public class Solution {
	
	/**DFS
	 * https://leetcode-cn.com/problems/surrounded-regions/solution/bfsdi-gui-dfsfei-di-gui-dfsbing-cha-ji-by-ac_pipe/
	 * @param board
	 */
//	public void solve(char[][] board) {
//		int row = board.length;
//		int col = board[0].length;
//		// 找邊界的o
//		for(int i = 0; i < row; i++) {
//			for(int j = 0; j < col; j++) {
//				if((i == 0 || j == 0 || i == row - 1 || j == col - 1) && board[i][j] == 'O') {
//					dfs(board, i, j);
//				}
//			}
//		}
//		
//		for(int i = 0; i < row; i++) {
//			for(int j = 0; j < col; j++) {
//				if(board[i][j] == 'O') {
//					board[i][j] = 'X';
//				}
//				
//				if(board[i][j] == '#') {
//					board[i][j] = 'O';
//				}
//			}
//		}
//	}
//	
//	private void dfs(char[][] board, int i, int j) {
//		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
//			return;
//		}
//		
//		board[i][j] = '#';
//		dfs(board, i + 1, j);
//		dfs(board, i - 1, j);
//		dfs(board, i, j + 1);
//		dfs(board, i, j - 1);
//	}
	
	/**BFS
	 * https://leetcode-cn.com/problems/surrounded-regions/solution/bfsdi-gui-dfsfei-di-gui-dfsbing-cha-ji-by-ac_pipe/
	 * @param board
	 */
//	public void solve(char[][] board) {
//		int row = board.length;
//		int col = board[0].length;
//		
//		
//		
//	}

}
