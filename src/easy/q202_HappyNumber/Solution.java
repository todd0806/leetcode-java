package easy.q202_HappyNumber;

import java.util.HashSet;
// https://leetcode.com/problems/happy-number/
public class Solution {
	public boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<>();
		while (n != 1) {
			int result = 0;
			while (n != 0) {
				result += (int) Math.pow(n % 10, 2);
				n /= 10;
			}
			if (set.contains(result)) {
				return false;
			}

			set.add(result);
			n = result;
		}
		return true;
	}
}
