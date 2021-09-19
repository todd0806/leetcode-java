package medium.q153FindMinimuminRotatedSortedArray;

/**
 * @author Todd
 *https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
 */
public class Solution {
	/**https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/yi-wen-jie-jue-4-dao-sou-suo-xuan-zhuan-pai-xu-s-2/
	 * @param nums
	 * @return
	 */
	public int findMin(int[] nums) {
		if(nums != null && nums.length == 1) {
			return nums[0];
		}	
		
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			
			if(nums[left] <= nums[right]) {
				return nums[left];
			}
			
			if(nums[left] <= nums[mid]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return -1;
	}
}
