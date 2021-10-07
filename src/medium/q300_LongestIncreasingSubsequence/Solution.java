package medium.q300_LongestIncreasingSubsequence;

import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class Solution {
	/**https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-dpzi-i1kh6/
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		if(nums.length == 1) {
			return 1;
		}
		
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		
		for(int i = 1; i < nums.length; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int ans = 1;
		for(int val: dp) {
			ans = Math.max(ans, val);
		}
		return ans;
	}

}
