package medium.q005_LongestPalindromicSubstring;

/**
 * @author Todd
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.print(
			new Solution().longestPalindrome("cbbd")
//			new Solution().longestPalindrome("babad")
		);
	}
	
	/**跟647幾乎一樣的題目
	 * https://leetcode-cn.com/problems/palindromic-substrings/solution/java-zhong-xin-kuo-zhan-fa-jian-dan-kuai-su-jie-ju/
	 * @param s
	 * @return
	 */
	int max = 0;
	String longest = "";
	public String longestPalindrome(String s) {
		for(int i = 0; i < s.length(); i++) {
			count(s, i, i);
			count(s, i, i+1);
		}
		return longest;
	}
	
	private void count(String s, int start, int end) {
		while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			if(end - start + 1 > max) {
				longest = s.substring(start, end + 1);
				max = end - start + 1;
			}
			start--;
			end++;
		}
	}
}
