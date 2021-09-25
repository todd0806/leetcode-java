package medium.q152_MaximumProductSubarray;

/**
 * @author Todd
 *         https://leetcode.com/problems/maximum-product-subarray/description/
 */
public class Solution {
	/**https://leetcode-cn.com/problems/maximum-product-subarray/solution/dpfang-fa-xiang-jie-by-yang-cong-12/
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {
		int[] maxDp = new int[nums.length];
		int[] minDp = new int[nums.length];
		int max = nums[0];
		maxDp[0] = nums[0];
		minDp[0] = nums[0];
		for(int i = 1; i < nums.length; i++) {
			// maxDp[i] = Max(maxDp[i - 1] * nums[i], nums[i], minDp[i - 1] * nums[i])
			maxDp[i] = Math.max(Math.max(maxDp[i - 1] * nums[i], nums[i]), minDp[i - 1] * nums[i]);
			// minDp[i] = Min(minDp[i - 1] * nums[i], nums[i], maxDp[i - 1] * nums[i])
			minDp[i] = Math.min(Math.min(minDp[i - 1] * nums[i], nums[i]), maxDp[i - 1] * nums[i]);
			max = Math.max(max, maxDp[i]);
		}
		return max;
	}
}
