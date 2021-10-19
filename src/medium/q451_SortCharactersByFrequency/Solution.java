package medium.q451_SortCharactersByFrequency;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
	public String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (Character c : map.keySet()) {
			queue.add(new int[] { c - 'a', map.get(c) });
		}

		int size = queue.size();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			int count = queue.peek()[1];
			char realChar = (char) ('a' + queue.poll()[0]);
			while (count > 0) {
				sb.append(realChar);
				count--;
			}
		}

		return sb.toString();
	}

}
