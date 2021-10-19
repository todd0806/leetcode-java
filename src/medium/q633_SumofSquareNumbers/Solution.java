package medium.q633_SumofSquareNumbers;

public class Solution {
	public static void main(String[] args) {
		new Solution().judgeSquareSum(2147483600);
	}

	// http://www.cyc2018.xyz/%E7%AE%97%E6%B3%95/Leetcode%20%E9%A2%98%E8%A7%A3/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E5%8F%8C%E6%8C%87%E9%92%88.html#_2-%E4%B8%A4%E6%95%B0%E5%B9%B3%E6%96%B9%E5%92%8C
	public boolean judgeSquareSum(int c) {
		if (c < 0) {
			return false;
		}
		long left = 0, right = (int) Math.sqrt(c);
		while (left <= right) {
			long cur = left * left + right * right;
			if (cur < c) {
				left++;
			} else if (cur > c) {
				right--;
			} else {
				return true;
			}
		}
		return false;
	}
}
