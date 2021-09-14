package medium.q055_JumpGame;

/**
 * @author Todd
 *https://leetcode.com/problems/jump-game/
 */
public class Solution {
	
	/**https://leetcode-cn.com/problems/jump-game/solution/55-by-ikaruga/
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		int max = 0;
		for(int i = 0; i < nums.length; i++) {
			if(i > max) {
				return false;
			}
			max = Math.max(max,  nums[i] + i);
		}
		return true;
	}
}
