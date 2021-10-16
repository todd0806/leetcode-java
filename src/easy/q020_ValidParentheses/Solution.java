package easy.q020_ValidParentheses;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class Solution {
	
	public static void main(String[] args) {
		System.out.print(new Solution().isValid("()"));
	}
	
	public boolean isValid(String s) {
		if (s.length() <= 1 || s.length() % 2 != 0) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				if (c == ')' && stack.peek() == '(') {
					stack.pop();
				} else if (c == ']' && stack.peek() == '[') {
					stack.pop();
				} else if (c == '}' && stack.peek() == '{') {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	/**改善可讀性
	 * @param s
	 * @return
	 */
//	public boolean isValid(String s) {
//		if(s.length() % 2 > 0) {
//			return false;
//		}
//		
//		Stack<Character> stack = new Stack<>();
//		for(Character ch : s.toCharArray()) {
//			if(ch == '{' || ch == '[' || ch == '(') {
//				stack.push(ch);
//			}else {
//				if(stack.empty() || !check(stack.pop(), ch)) {
//					return false;
//				}
//			}
//		}
//		if(!stack.isEmpty()) {
//			return false;
//		}
//		return true;
//	}
//	
//	private boolean check(Character pop, Character right) {
//		if(right == ')' && pop == '(') {
//			return true;
//		}else if(right == ']' && pop == '[') {
//			return true;
//		}else if(right == '}' && pop == '{') {
//			return true;
//		}
//		return false;
//	}
	
	
	
	/**之前寫的解法
	 * @param s
	 * @return
	 */
//	public static boolean isValid(String s) {
//		Stack<Character> stack = new Stack<Character>();
//		if(s.length() % 2 > 0 || s.length() == 0) {
//			return false;
//		}
//		for(char c : s.toCharArray()) {
//			if(c == '}') {
//				if(!stack.empty() && stack.pop() == '{') {
//					continue;
//				}else {
//					return false;
//				}
//			}else if(c == ']') {
//				if(!stack.empty() && stack.pop() == '[') {
//					continue;
//				}else {
//					return false;
//				}
//			}else if(c== ')') {
//				if(!stack.empty() && stack.pop() == '(') {
//					continue;
//				}else {
//					return false;
//				}
//			}else {
//				stack.push(c);
//			}
//		}
//		
//		return stack.size() == 0 ? true : false;
//    }
}
