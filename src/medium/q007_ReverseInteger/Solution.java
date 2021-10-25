package medium.q007_ReverseInteger;

//https://leetcode.com/problems/reverse-integer/
public class Solution {

	public static void main(String[] args) {
		System.out.print(new Solution().reverse(900000));
	}

	public int reverse(int x) {
		if (x == 0) {
			return 0;
		} else if (x == 10) {
			return 1;
		}

		int ans = 0;
		boolean negative = x < 0;
		x = Math.abs(x);
		while (x != 0) {
			// 假設 輸入值是 123 newResult 第一次為 0*10+3 = 3 , 第二次為 3*10+2 = 32 , 第三次為
			// 32*10+1 = 321
			// 判斷溢出，檢核計算後值是否相同，因為Java如果值溢出會壞掉 Ex:964632435*10 會變成 1056389758
			int testResutl = ans * 10 + x % 10;
			if ((testResutl - x % 10) / 10 != ans) {
				return 0;
			}

			ans = ans * 10 + x % 10;
			x = x / 10;
		}
		return negative ? -1 * ans : ans;
	}
}
