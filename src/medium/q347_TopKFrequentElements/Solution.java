package medium.q347_TopKFrequentElements;

import java.util.HashMap;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/
public class Solution {
	public static void main(String[] args) {
//		System.out.print("test");
		int[] ints = { 2, 7, 11, 15, 2, 3, 4, 7, 7 };
		System.out.print(new Solution().topKFrequent(ints, 2));
	}
	
	public int[] topKFrequent(int[] nums, int k) {
		// integer, count
		HashMap<Integer, Integer> map = new HashMap<>();
		// max heap
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (int num : map.keySet()) {
			queue.add(new int[] { num, map.get(num) });
		}

		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = queue.poll()[0];
		}
		return ans;
	}

//	public static List<Integer> topKFrequent(int[] nums, int k) {
//		List<Integer>[] buckets = new List[nums.length + 1];
//		Map<Integer, Integer> counts = new HashMap<>();
//
//		for (int num : nums)
//			counts.put(num, counts.getOrDefault(num, 0) + 1);
//
//		for (int num : counts.keySet()) {
//			int count = counts.get(num);
//			if (buckets[count] == null)
//				buckets[count] = new ArrayList<Integer>();
//			buckets[count].add(num);
//		}
//
//		List<Integer> ans = new ArrayList<>();
//		for (int i = buckets.length - 1; i > 0 && ans.size() < k; --i) {
//			if (buckets[i] != null)
//				ans.addAll(buckets[i]);
//		}
//		return ans;
//	}
}
