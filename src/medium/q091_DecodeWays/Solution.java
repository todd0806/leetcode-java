package medium.q091_DecodeWays;

import java.util.Arrays;

/**
 * @author Todd
 * https://leetcode.com/problems/decode-ways/
 */
public class Solution {

	public static void main(String[] args) {
		System.out.print(
			new Solution().numDecodings("06")
		);
	}
	
	
	/**DP
	 *https://leetcode-cn.com/problems/decode-ways/solution/shu-ju-jie-gou-he-suan-fa-di-gui-he-dong-pnyf/ 
	 * @param s
	 * @return
	 */
//	public int numDecodings(String s) {
//		char[] chars = s.toCharArray();
//		int[] dp = new int[s.length() + 1];
//		// 關鍵預設值
//		dp[0] = 1;
//		for(int i = 1; i <= s.length(); i++) {
//			if(chars[i - 1] != '0') {
//				dp[i] = dp[i - 1];
//			}
//			//dp[i - 2]，只有在條件都滿足才能納入計算
//			if(i - 2 >= 0 && (chars[i - 2] == '1' || (chars[i - 2] == '2' && chars[i - 1] <= '6'))) {
//				dp[i] += dp[i - 2];
//			}
//		}
//		return dp[s.length()];
//	}
	
	// 空間優化
	public int numDecodings(String s) {
		char[] chars = s.toCharArray();
		int prePre = 0;
		// 關鍵預設值
		int pre = 1;
		for(int i = 1; i <= s.length(); i++) {
			int cur = 0;
			if(chars[i - 1] != '0') {
				cur += pre;
			}
			//dp[i - 2]，只有在條件都滿足才能納入計算
			if(i - 2 >= 0 && (chars[i - 2] == '1' || (chars[i - 2] == '2' && chars[i - 1] <= '6'))) {
				cur += prePre;
			}
			prePre = pre;
			pre = cur;
		}
		return pre;
	}
	
	/**DFS
	 * https://leetcode-cn.com/problems/decode-ways/solution/shu-ju-jie-gou-he-suan-fa-di-gui-he-dong-pnyf/
	 * @param s
	 * @return
	 */
//	public int numDecodings(String s) {
//		int[] memo = new int[s.length() + 1];
//		Arrays.fill(memo, -1);
//		return dfs(s, 0, memo);
//	}
//	
//	private int dfs(String s, int index, int[] memo) {
//		if(index == s.length()) {
//			return 1;
//		}
//		if(s.charAt(index) == '0') {
//			return 0;
//		}
//		
//		if(memo[index] != -1) {
//			return memo[index];
//		}
//		
//		int sum1 = 0;
//		if(index + 1 <= s.length()) {
//			sum1 = dfs(s, index + 1, memo);
//		}
//		int sum2 = 0;
//		if(index + 2 <= s.length() && Integer.parseInt(s.substring(index, index + 2))<= 26) {
//			sum2 = dfs(s, index + 2, memo);
//		}
//		memo[index] = sum1 + sum2;
//		return memo[index];
//	}

}
