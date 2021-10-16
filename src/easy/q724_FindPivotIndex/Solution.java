package easy.q724_FindPivotIndex;

// https://leetcode.com/problems/find-pivot-index/

public class Solution {
	
	public int pivotIndex(int[] nums) {
		int total = 0;
		for (int x : nums) {
			total += x;
		}

		int leftSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (total - leftSum - nums[i] == leftSum) {
				return i;
			}
			leftSum += nums[i];
		}

		return -1;
	}
}
