package easy.q020_ValidParentheses;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class Solution {
	
	public static void main(String[] args) {
		System.out.print(isValid("){"));
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		if(s.length() % 2 > 0 || s.length() == 0) {
			return false;
		}
		for(char c : s.toCharArray()) {
			if(c == '}') {
				if(!stack.empty() && stack.pop() == '{') {
					continue;
				}else {
					return false;
				}
			}else if(c == ']') {
				if(!stack.empty() && stack.pop() == '[') {
					continue;
				}else {
					return false;
				}
			}else if(c== ')') {
				if(!stack.empty() && stack.pop() == '(') {
					continue;
				}else {
					return false;
				}
			}else {
				stack.push(c);
			}
		}
		
		return stack.size() == 0 ? true : false;
    }

}
