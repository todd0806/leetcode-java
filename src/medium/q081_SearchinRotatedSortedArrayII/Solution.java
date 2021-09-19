package medium.q081_SearchinRotatedSortedArrayII;

/**
 * @author Todd
 *https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class Solution {
	/**https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/fu-xue-ming-zhu-bang-zhu-ni-geng-shen-ke-zcu0/
	 * @param nums
	 * @param target
	 * @return
	 */
	public boolean search(int[] nums, int target) {
		if(nums != null && nums.length == 1 && nums[0] == target) {
			return true;
		}		
		
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] == target) {
				return true;
			}
			if(nums[left] == nums[right]) {
				left = left + 1;
				continue;
			}
			
			if(nums[left] <= nums[mid]) {
				if(nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				}else {
					left = mid + 1;
				}
			}else {
				if(nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				}else {
					right = mid - 1;
				}
			}
		}
		return false;
	}
}
