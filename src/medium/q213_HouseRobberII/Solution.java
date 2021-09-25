package medium.q213_HouseRobberII;

/**
 * @author Todd
 * https://leetcode.com/problems/house-robber-ii/description/
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.print(
				new Solution().rob(new int[] {2,3,2})
		);
	}
	
	/**https://leetcode-cn.com/problems/house-robber-ii/solution/dai-ma-sui-xiang-lu-da-jia-jie-she-xi-li-nuhz/
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return nums[0];
		}
		return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
	}
	
	public int rob(int[] nums, int start, int end) {
		int cur = 0, pre = 0;
		for(int i = start; i < end; i++) {
			int temp = cur;
			cur = Math.max(pre + nums[i], cur);
			pre = temp;
		}
		return cur;
	}
}
