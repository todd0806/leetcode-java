package hard.q051_NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Todd
 *https://leetcode.com/problems/n-queens/
 */
public class Solution {
	
	//https://leetcode-cn.com/problems/n-queens/solution/dai-ma-sui-xiang-lu-51-n-queenshui-su-fa-2k32/
	
	private List<List<String>> result = new ArrayList<>();
	
	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for(char[] c: board) {
			Arrays.fill(c, '.');
		}
		bracket(0, n, board);
		return result;
	}
	
	private void bracket(int row, int n, char[][] board) {
		if(row == n) {
			result.add(charArrayToList(board));
			return;
		}
		
		for(int col = 0; col < n; col++) {
			if(isValid(row, col, n, board)) {
				board[row][col] = 'Q';
				bracket(row + 1, n, board);
				board[row][col] = '.';
			}
		}
	}
	
	private boolean isValid(int row, int col, int n, char[][] board) {
		// 檢查列
		for(int i = 0; i < n; i++) {
			if(board[i][col] == 'Q') {
				return false;
			}
		}
		
		// 檢查左上斜線(135度角)
		for(int i = row -1 , j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if(board[i][j] == 'Q') {
				return false;
			}
		}
		
		//檢查右上斜線(45度角)
		for(int i = row -1 , j = col + 1; i >= 0 && j <= n; i--, j++) {
			if(board[i][j] == 'Q') {
				return false;
			}
		}
		
		return true;
	}
	
	private List<String> charArrayToList(char[][] board){
		List<String> list = new ArrayList<>();
		for(char[] c: board) {
			list.add(String.valueOf(c));
		}
		return list;
	}
	
}
