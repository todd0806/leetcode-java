package easy.q053_MaximumSubarray;

//https://leetcode.com/problems/maximum-subarray/

public class Solution {

	public static void main(String[] args) {
		int[] nums = {1, 4, 2, -1, 2};
		System.out.print(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int maxForNow = 0;
		for(int i = 0; i < nums.length; i++) {
			maxForNow = Math.max(maxForNow + nums[i], nums[i]);
			max = Math.max(maxForNow, max);
		}
		return max;
	}
}
