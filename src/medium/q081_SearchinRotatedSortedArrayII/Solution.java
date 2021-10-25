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
			
//			第一类
//			10111 和 11101 这种。此种情况下 nums[start] == nums[mid]，分不清到底是前面有序还是后面有序，此时 start++ 即可。相当于去掉一个重复的干扰项。
//			第二类
//			2345671 这种，也就是 nums[start] < nums[mid]。此例子中就是 2 < 5；
//			这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
//			第三类
//			6712345 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2；
//			这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]。则在后半部分找，否则去前半部分找。
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
