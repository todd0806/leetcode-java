package medium.q347_AddTwoNumbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/add-two-numbers/
public class Solution {

	public static void main(String[] args) {
//		System.out.print("test");
		int[] ints = { 2, 7, 11, 15, 2, 3, 4, 7, 7 };
		System.out.print(topKFrequent(ints, 2));
	}

	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer>[] buckets = new List[nums.length + 1];
		Map<Integer, Integer> counts = new HashMap<>();

		for (int num : nums)
			counts.put(num, counts.getOrDefault(num, 0) + 1);

		for (int num : counts.keySet()) {
			int count = counts.get(num);
			if (buckets[count] == null)
				buckets[count] = new ArrayList<Integer>();
			buckets[count].add(num);
		}

		List<Integer> ans = new ArrayList<>();
		for (int i = buckets.length - 1; i > 0 && ans.size() < k; --i) {
			if (buckets[i] != null)
				ans.addAll(buckets[i]);
		}
		return ans;
	}
}
