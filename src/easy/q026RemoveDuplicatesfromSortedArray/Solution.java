package easy.q026RemoveDuplicatesfromSortedArray;

import java.util.HashMap;

public class Solution {
	public int removeDuplicates(int[] nums) {
		// num, count
		HashMap<Integer, Integer> map = new HashMap<>();
		int left = 0;
		for (int i = 0; i < nums.length; i++) {
			int count = map.getOrDefault(nums[i], 0);
			if (count == 0) {
				nums[left] = nums[i];
				map.put(nums[i], 1);
				left++;
			}
		}
		return left;
	}
}
