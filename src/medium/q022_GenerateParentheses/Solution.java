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
	
	private List<String> list = new ArrayList<>();
	public List<String> generateParenthesis(int n) {
		generate(0, 0, n, "");
		return list;
	}
	
	private void generate(Integer left, Integer right, Integer maxLevel, String s) {
		// terminator
		if(left == maxLevel && right == maxLevel) {
			System.out.println(s);
			list.add(s);
			return;
		}
		
		//procee current logic left, right
		
		//drilldown
		if(left < maxLevel) {
			generate(left  + 1, right, maxLevel, s + "(");
		}
		
		if(right < left ) {
			generate(left, right  + 1, maxLevel, s + ")");
		}
		
		//reverse states
	}
	
	
}
