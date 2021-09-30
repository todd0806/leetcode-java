package hard.q032LongestValidParentheses;

import java.util.Stack;

/**
 * @author Todd
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class Solution {
	public static void main(String[] args) {
		System.out.print(
			new Solution().longestValidParentheses("(()")
//			new Solution().longestValidParentheses("()(()")
		);
	}
	
	/**Stack
	 * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zhan-zui-jian-jie-yi-dong-de-dai-ma-cjav-xa7v/
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		if(s == null || s.length() <= 1) {
			return 0;
		}
		
		char[] chars = s.toCharArray();
		Stack<Integer> stack = new Stack<>();
		int total = 0;
		int startIndex = 0;
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == '(') {
				stack.add(i);
			}else {
				if(!stack.isEmpty()){
					stack.pop();
					if(stack.isEmpty()) {
						total = Math.max(total, i - startIndex + 1);
					}else {
						total = Math.max(total, i - stack.peek());
					}
				}else {
					startIndex = i + 1;
				}
			}
		}
		return total;
	}
}
