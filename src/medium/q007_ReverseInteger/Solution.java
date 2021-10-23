package medium.q007_ReverseInteger;

//https://leetcode.com/problems/reverse-integer/
public class Solution {

	public static void main(String[] args) {
		System.out.print(reverse(900000));
	}

	public static int reverse(int x) {
		long res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x = x / 10;
		}
		if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
			return 0;
		} else {
			return (int) res;
		}
	}

}
