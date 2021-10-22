package medium.q189_RotateArray;
// https://leetcode.com/problems/rotate-array/

public class Solution {
//	Input: nums = [1,2,3,4,5,6,7], k = 3
//	Output: [5,6,7,1,2,3,4]
//	1st: 7,6,5,4,3,2,1
//	2nd: 5,6,7,4,3,2,1
//	3rd: 5,6,7,1,2,3,4
	
	// rotate to right
	public void rotate(int[] nums, int k) {
		if (k > nums.length) {
			k = k % nums.length;
		}
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}
	

//  Input: nums = [1,2,3,4,5,6,7], k = -3
//	Output: [4,5,6,7,1,2,3]
//	1: 3,2,1,4,5,6,7
//	2: 3,2,1,7,6,5,4
//	3: 4,5,6,7,1,2,3
	public void rotateToLeft(int[] nums, int k) {
		if (k > nums.length) {
			k = k % nums.length;
		}
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}
	
	private void reverse(int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}
	
	
}
