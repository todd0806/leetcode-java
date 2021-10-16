package medium.q503_NextGreaterElementII;

import java.util.ArrayDeque;

// https://leetcode.com/problems/next-greater-element-ii/
public class Solution {
	//https://labuladong.gitee.io/algo/2/21/46/
	public int[] nextGreaterElements(int[] nums) {
		int[] ans = new int[nums.length];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int n = nums.length;
		for (int i = n * 2 - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
				stack.pop();
			}
			ans[i % n] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(nums[i % n]);
		}
		return ans;
	}
}
