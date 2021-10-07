package easy.q704_BinarySearch;

// https://leetcode.com/problems/binary-search/
public class Solution {
	public static void main(String[] args) {
		new Solution().search(new int[] {-1,0,3,5,9,12}, 9);
	}
	
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] == target) {
				return mid;
			}else if(nums[mid] > target) {
				right = mid - 1;
			}else if(nums[mid] < target) {
				left = mid + 1;
			}
		}
		return -1;
	}
}
