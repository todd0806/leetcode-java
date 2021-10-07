package hard.q052_NQueensII;

import java.util.Arrays;

/**
 * @author Todd https://leetcode.com/problems/n-queens-ii/
 */
public class Solution {

	/**
	 * https://leetcode-cn.com/problems/n-queens-ii/solution/jsjian-dan-yi-dong-hui-su-fa-by-yao-n1-ydks/
	 * 
	 * @param n
	 * @return
	 */
	int ans = 0;

	public int totalNQueens(int n) {
		if (n == 1) {
			return 1;
		}
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(board[i], '.');
		}
		bracket(board, 0);
		return ans;
	}

	private void bracket(char[][] board, int row) {
		if (row == board.length) {
			ans++;
			return;
		}

		for (int col = 0; col < board.length; col++) {
			if (isValid(board, row, col)) {
				board[row][col] = 'Q';
				bracket(board, row + 1);
				board[row][col] = '.';
			}
		}
	}

	private boolean isValid(char[][] board, int row, int col) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == 'Q') {
				return false;
			}
		}

		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}

		for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}
}
