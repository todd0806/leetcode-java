package medium.q012_IntegertoRoman;

// https://leetcode.com/problems/integer-to-roman/
public class Solution {
	public String intToRoman(int num) {
		String[] romanArray = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		Integer[] numArray = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			for (int i = 0; i < numArray.length; i++) {
				if (num >= numArray[i]) {
					sb.append(romanArray[i]);
					num -= numArray[i];
					break;
				}
			}
		}
		return sb.toString();
	}
}
