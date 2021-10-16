package easy.q496_NextGreaterElementI;

import java.util.ArrayDeque;
import java.util.HashMap;

// https://leetcode.com/problems/next-greater-element-i/
public class Solution {
	// Stack
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		int[] ans = new int[findNums.length];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= nums[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				map.put(nums[i], -1);
			} else {
				map.put(nums[i], stack.peek());
			}
			stack.push(nums[i]);
		}
		for (int i = 0; i < findNums.length; i++) {
			ans[i] = map.get(findNums[i]);
		}

		return ans;
	}
	
	// 暴力法
//	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//		int[] ans = new int[nums1.length];
//		HashMap<Integer, Integer> nums2Map = new HashMap<>();
//		for (int i = 0; i < nums2.length; i++) {
//			nums2Map.put(nums2[i], i);
//		}
//
//		for (int i = 0; i < nums1.length; i++) {
//			int startIndex = nums2Map.getOrDefault(nums1[i], -1);
//			if (startIndex == -1) {
//				ans[i] = -1;
//			} else {
//				while (++startIndex < nums2.length && nums1[i] >= nums2[startIndex]) {
//					// do nothing
//				}
//				ans[i] = startIndex >= nums2.length ? -1 : nums2[startIndex];
//			}
//		}
//		return ans;
//	}
}
