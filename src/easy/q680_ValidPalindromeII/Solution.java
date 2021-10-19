package easy.q680_ValidPalindromeII;

public class Solution {
	public static void main(String[] args) {
		new Solution().validPalindrome("abc");
	}
	
	public boolean validPalindrome(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
			}
		}
		return true;
	}
	
	private boolean isPalindrome(String s, int left, int right) {
		while(left < right) {
			if(s.charAt(left++) != s.charAt(right--)) {
				return false;
			}
		}
		return true;
	}
	
//	public boolean validPalindrome(String s) {
//		if (s != null && s.length() <= 1) {
//			return true;
//		}
//
//		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
//			if (s.charAt(i) != s.charAt(j)) {
//				return isPalindrome(s.substring(i, j)) || isPalindrome(s.substring(i + 1, j + 1));
//			}
//		}
//
//		return true;
//	}
//
//	private boolean isPalindrome(String s) {
//		int left = 0;
//		int right = s.length() - 1;
//		while (left < right) {
//			if (s.charAt(left++) != s.charAt(right--)) {
//				return false;
//			}
//		}
//		return true;
//	}
}
