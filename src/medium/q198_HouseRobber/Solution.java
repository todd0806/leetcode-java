package medium.q198_HouseRobber;

/**
 * @author Todd https://leetcode.com/problems/house-robber/
 */
public class Solution {
	/**https://leetcode-cn.com/problems/house-robber/solution/dong-tai-gui-hua-jie-ti-si-bu-zou-xiang-jie-cjavap/
	 * 	时间复杂度O(N) ： 遍历 nums 需要线性时间；
		空间复杂度O(N) 
	 * @param nums
	 * @return
	 */
//	public int rob(int[] nums) {
//		if(nums.length  == 0) {
//			return 0;
//		}else if (nums.length == 1) {
//			return nums[0];
//		}
//		
//		int[] dp =  new int[nums.length + 1];
//		dp[0] = 0;
//		dp[1] = nums[0];
//		for(int i = 2; i <= nums.length; i++) {
//			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
//		}
//		return dp[nums.length];
//	}
	
	/**空間節省
	 * https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-dong-tai-gui-hua-jie-gou-hua-si-lu-/
	 *  时间复杂度 O(N) ： 遍历 nums 需要线性时间；
		空间复杂度 O(1) ： cur和 pre 使用常数大小的额外空间。
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		if(nums.length  == 0) {
			return 0;
		}else if (nums.length == 1) {
			return nums[0];
		}
		
		int pre = 0, cur = 0;
		for(int num: nums) {
			int temp = cur;
			cur = Math.max(pre + num, cur);
			pre = temp;
		}
		return cur;
	}
}
