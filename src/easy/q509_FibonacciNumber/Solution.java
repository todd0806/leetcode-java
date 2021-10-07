package easy.q509_FibonacciNumber;

import java.util.HashMap;

//https://leetcode.com/problems/fibonacci-number/submissions/

public class Solution {

	/**
	 * @param n
	 * @return
	 */
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public int fib(int n) {
		if (n <= 1) {
			return n;
		}

		if (map.containsKey(n)) {
			return map.get(n);
		} else {
			map.put(n, fib(n - 1) + fib(n - 2));
		}
		return map.get(n);
	}
}
