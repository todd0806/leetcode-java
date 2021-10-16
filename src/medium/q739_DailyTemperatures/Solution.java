package medium.q739_DailyTemperatures;

import java.util.ArrayDeque;

// https://leetcode.com/problems/daily-temperatures/
public class Solution {
	// https://leetcode.com/problems/daily-temperatures/discuss/109832/Java-Easy-AC-Solution-with-Stack
	// stack
	public int[] dailyTemperatures(int[] temperatures) {
		int[] ans = new int[temperatures.length];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = temperatures.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				ans[i] = 0;
			} else {
				ans[i] = stack.peek() - i;
			}
			stack.push(i);
		}
		return ans;
	}

	// 暴力法
//	public int[] dailyTemperatures(int[] temperatures) {
//		int[] ans = new int[temperatures.length];
//		for (int i = 0; i < temperatures.length; i++) {
//			int count = 0;
//			for (int j = i + 1; j < temperatures.length; j++) {
//				count++;
//				if (temperatures[j] > temperatures[i]) {
//					ans[i] = count;
//					break;
//				}
//			}
//		}
//		return ans;
//	}
}
