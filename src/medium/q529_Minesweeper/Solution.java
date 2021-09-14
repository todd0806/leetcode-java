package medium.q529_Minesweeper;

/**
 * @author Todd
 *https://leetcode.com/problems/minesweeper/description/
 */
public class Solution {
	/**DFS
	 * https://leetcode-cn.com/problems/minesweeper/solution/cong-qi-dian-kai-shi-dfs-bfs-bian-li-yi-bian-ji-ke/
	 * @param board
	 * @param click
	 * @return
	 */
	int[] dy = new int[] {-1, 1, 0, 0, -1, 1, -1, 1};
	int[] dx = new int[] {0, 0, 1, -1, 1, 1, -1, -1};
	public char[][] updateBoard(char[][] board, int[] click) {
		int y = click[0];
		int x = click[1];
		
		if(board[y][x] == 'M') {
			board[y][x] = 'X';
			return board;
		}
		
		dfs(y, x, board);
		return board;
	}
	
	private void dfs(int i, int j, char[][] board) {
		int count = 0;
		for(int k = 0; k < dy.length; k++) {
			int y = i + dy[k];
			int x = j + dx[k];
			if(x < 0 || y < 0 || y >= board.length || x >= board[0].length) {
				continue;
			}
			if(board[y][x] == 'M') {
				count++;
			}
		}
		if(count > 0) {
			board[i][j] = (char)('0' + count);
			return;
		}
		
		board[i][j] = 'B';
		for(int k = 0; k < dy.length; k++) {
			int y = i + dy[k];
			int x = j + dx[k];
			if(x < 0 || y < 0 || y >= board.length || x >= board[0].length || board[y][x] != 'E') {
				continue;
			}
			dfs(y, x, board);
		}
	}
}
