package medium.q647_PalindromicSubstrings;

/**
 * @author Todd 
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class Solution {
	public static void main(String[] args) {
		System.out.print(
//			new Solution().countSubstrings("abc")
			new Solution().countSubstrings("aaa")
		);
	}
	/**https://leetcode-cn.com/problems/palindromic-substrings/solution/java-zhong-xin-kuo-zhan-fa-jian-dan-kuai-su-jie-ju/
	 * @param s
	 * @return
	 */
	public int countSubstrings(String s) {
		int ret = 0;
		for(int i = 0; i < s.length(); i++) {
			ret += count(s, i, i);
			ret += count(s, i, i + 1);
		}
		return ret;
	}
	
	private int count(String s, int start, int end) {
		int ret = 0;
		while(start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) {
			ret++;
		}
		return ret;
	}
}
