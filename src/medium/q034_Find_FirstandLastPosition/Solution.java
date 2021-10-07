package medium.q034_Find_FirstandLastPosition;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class Solution {
	
	public int[] searchRange(int[] nums, int target) {
		int[] ans = new int[2];
		ans[0] = findFirst(nums, target);
		ans[1] = findLast(nums, target);
		return ans;
	}
	
	private int findFirst(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] < target) {
				left = mid + 1;
			}else if(nums[mid] > target) {
				right = mid - 1;
			}else if(nums[mid] == target) {
				right = mid - 1;
			}
		}
		if(left >= nums.length || nums[left] != target) {
			return -1;
		}
		return left;
	}
	
	private int findLast(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] < target) {
				left = mid + 1;
			}else if(nums[mid] > target) {
				right = mid - 1;
			}else if(nums[mid] == target) {
				left = mid + 1;
			}
		}
		if(right < 0 || nums[right] != target) {
			return -1;
		}
		return right;
	}
}
