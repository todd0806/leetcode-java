package medium.q018_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/4sum/
public class Solution {

	public static void main(String[] args) {
		new Solution().fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0);
	}

	// https://leetcode-cn.com/problems/4sum/solution/jian-jian-dan-dan-si-zhi-zhen-he-san-shu-zhhe/
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums.length < 4) {
			return ans;
		}
		Arrays.sort(nums);
		for (int a = 0; a < nums.length - 2; a++) {
			if (a > 0 && nums[a] == nums[a - 1]) {
				continue;
			}
			for (int b = a + 1; b < nums.length - 1; b++) {
				if (b > a + 1 && nums[b] == nums[b - 1]) {
					continue;
				}

				int i = b + 1;
				int j = nums.length - 1;
				while (i < j) {
					int sum = nums[a] + nums[b] + nums[i] + nums[j];
					if (sum == target) {
						List<Integer> item = Arrays.asList(nums[a], nums[b], nums[i], nums[j]);
						ans.add(item);
						while (i < j && nums[i] == nums[++i])
							;
						while (i < j && nums[j] == nums[--j])
							;
					} else if (sum > target) {
						while (i < j && nums[j] == nums[--j])
							;
					} else if (sum < target) {
						while (i < j && nums[i] == nums[++i])
							;
					}
				}

			}
		}
		return ans;
	}

}
