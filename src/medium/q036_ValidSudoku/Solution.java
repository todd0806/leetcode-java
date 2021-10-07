package medium.q036_ValidSudoku;

/**
 * @author Todd
 * https://leetcode.com/problems/valid-sudoku/description/
 */
public class Solution {
	
	/**https://leetcode-cn.com/problems/valid-sudoku/solution/pythonjava-bian-li-qi-pan-ji-lu-xing-lie-mjf2/
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
		int n = board.length;
		boolean[][] row = new boolean[n][n];
		boolean[][] col = new boolean[n][n];
		boolean[][] block = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == '.') {
					continue;
				}
				
				int num = board[i][j] - '1';
				int whichBlock = i / 3 * 3 + j / 3;
				if(row[i][num] || col[j][num] || block[whichBlock][num]) {
					return false;
				}
				row[i][num] = true;
				col[j][num] = true;
				block[whichBlock][num] = true;
			}
		}
		return true;
	}
}
