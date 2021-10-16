package medium.q008_StringtoInteger;

//https://leetcode.com/problems/string-to-integer-atoi/
public class Solution {
	
	// https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/
	public int myAtoi(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int index = 0;
		boolean negative = false;
		char[] chars = s.toCharArray();
		int size = chars.length;
		// trim
		while (index < size) {
			if (chars[index] == ' ') {
				index++;
			} else {
				break;
			}
		}

		if (index >= size) {
			return 0;
		}

		// negative or positive
		if (chars[index] == '-') {
			negative = true;
			index++;
		} else if (chars[index] == '+') {
			index++;
		} else if (!Character.isDigit(chars[index])) {
			return 0;
		}

		int ans = 0;
		while (index < size) {
			if (!Character.isDigit(chars[index])) {
				break;
			}
			// ans * 10 + digit > Integer.MAX_VALUE
			int digit = (chars[index] - '0');
			if (ans > (Integer.MAX_VALUE - digit) / 10) {
				return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}

			ans = ans * 10 + digit;
			index++;
		}
		return negative ? -1 * ans : ans;
	}

}
