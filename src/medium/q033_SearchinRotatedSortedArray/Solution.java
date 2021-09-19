package medium.q033_SearchinRotatedSortedArray;

/**
 * @author Todd
 *https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Solution {
	public static void main(String[] args) {
		System.out.print(new Solution().search(new int[] {4,5,6,7,0,1,2}, 0));
	}
	
	
	/**https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/yi-wen-jie-jue-4-dao-sou-suo-xuan-zhuan-pai-xu-s-2/
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		if(nums != null && nums.length == 1) {
			if(nums[0] == target) {
				return 0;
			}else {
				return -1;
			}
		}
		
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] == target ) {
				return mid;
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
		return -1;
	}
}
