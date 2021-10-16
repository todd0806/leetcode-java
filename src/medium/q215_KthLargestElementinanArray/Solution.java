package medium.q215_KthLargestElementinanArray;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class Solution {
	// https://labuladong.gitee.io/algo/4/29/121/
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int num : nums) {
			queue.add(num);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		return queue.peek();
	}
}
