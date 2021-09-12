package easy.q169_MajorityElement;

import java.util.Arrays;

/**
 * @author Todd
 *https://leetcode.com/problems/majority-element/
 */
public class Solution {
	/**方法一：排序後，中間值必為眾數
	 * @param nums
	 * @return
	 */
//	public int majorityElement(int[] nums) {
//		Arrays.sort(nums);
//		return nums[nums.length / 2];
//	}
	
	/**方法2：Moore Vote
	 * https://leetcode-cn.com/problems/majority-element/solution/169duo-shu-yuan-su-by-sakura-irb-m6i2/
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		int majority = nums[0];
		int count = 1;
		for(int i = 1; i < nums.length; i++) {
			if(majority == nums[i]) {
				count ++;
			}else if(majority != nums[i]) {
				count--;
			}
			
			if (count == 0) {
				majority = nums[i];
				count++;
			}
		}
		return majority;
	}
	
	
}
