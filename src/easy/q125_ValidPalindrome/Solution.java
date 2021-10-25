package easy.q125_ValidPalindrome;

//  https://leetcode.com/problems/valid-palindrome/
public class Solution {
	public static void main(String[] args) {
		new Solution().isPalindrome("A man, a plan, a canal: Panama");

	}

	public boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			if (!Character.isLetterOrDigit(s.charAt(left))) {
				left++;
				continue;
			}
			if (!Character.isLetterOrDigit(s.charAt(right))) {
				right--;
				continue;
			}

			char leftChar = Character.toLowerCase(s.charAt(left++));
			char rightChar = Character.toLowerCase(s.charAt(right--));
			if (leftChar != rightChar) {
				return false;
			}
		}
		return true;
	}
}
