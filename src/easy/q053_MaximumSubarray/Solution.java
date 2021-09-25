package easy.q053_MaximumSubarray;

//https://leetcode.com/problems/maximum-subarray/

public class Solution {

	public static void main(String[] args) {
		int[] nums = {-1, -2};
		System.out.print(new Solution().maxSubArray(nums));
	}
	
	
	/**https://leetcode-cn.com/problems/maximum-subarray/solution/dai-ma-sui-xiang-lu-53-zui-da-zi-xu-he-b-xqus/
	 * 1.dp[i]代表当前下标对应的最大值
     * 2.递推公式 dp[i] = max (dp[i-1]+nums[i],nums[i]) res = max(res,dp[i])
     * 3.初始化 都为 0
     * 4.遍历方向，从前往后
     * 5.举例推导结果。。。
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		if(nums.length == 1) {
			return nums[0];
		}
		
		int max = nums[0];
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for(int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			max = dp[i] > max ? dp[i]: max;
		}
		return max;
	}
	
	/**暴力法
	 * @param nums
	 * @return
	 */
//	public int maxSubArray(int[] nums) {
//		int max = Integer.MIN_VALUE;
//		for(int i  = 0; i < nums.length; i++) {
//			int newSum = 0;
//			for(int j = i; j < nums.length; j++) {
//				 newSum += nums[j];
//				 max = Math.max(max, newSum);
//			}
//		}
//		return max;
//	}


	
}
