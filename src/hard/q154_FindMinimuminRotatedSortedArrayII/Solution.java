package hard.q154_FindMinimuminRotatedSortedArrayII;

/**
 * @author Todd
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class Solution {
	
	/**https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/154-xun-zhao-xuan-zhuan-pai-xu-shu-zu-zh-26hh/
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
			if(nums[mid] < nums[right]) {
				right = mid;
			}else if(nums[mid] > nums[right]) {
				left = mid + 1;
			}else if(nums[right] == nums[mid]) {
				right--;
			}
		}
		return nums[left];
	}
}
