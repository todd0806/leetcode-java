package medium.q022_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Todd
 *https://leetcode.com/problems/generate-parentheses/
 */
public class Solution {
	public static void main(String[] args) {
		new Solution().generateParenthesis(3);
	}
	
	// dfs
	List<String> result = new ArrayList<>();
	public List<String> generateParenthesis(int n){
		dfs(0, 0, n, "");
		return result;
	}
	
	private void dfs(int left, int right, int n, String s) {
		if(left == n && right == n ) {
			result.add(s);
//			System.out.println(s);
		}
		
		if(left < n) {
			dfs(left + 1, right, n, s + ("("));
		}
		
		if(left > right) {
			dfs(left, right + 1, n, s + (")") );
		}
	}
	
	// DFS or BFS
	// https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
	
	
}
