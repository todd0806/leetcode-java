package easy.q013_RomanToInteger;

//https://leetcode.com/problems/roman-to-integer/
public class Solution {

	public static void main(String[] args) {
		System.out.print(new Solution().romanToInt("MCMXCIV"));
	}

	public int romanToInt(String s) {
		int ans = 0;
		int left = 0;
		int end = s.length();
		while (left < end) {
			if (left + 2 <= end) {
				if(check(s.substring(left, left + 2)) > 0) {
					ans += mapping(s.substring(left, left + 2));
					left += 2;
					continue;
				}
			}
			ans += mapping(s.substring(left, left + 1));
			left++;
		}
		return ans;
	}
	
	private int check(String s) {
		switch (s) {
			case "IV":
				return 4;
			case "IX":
				return 9;
			case "XL":
				return 40;
			case "XC":
				return 90;
			case "CD":
				return 400;
			case "CM":
				return 900;
			default:
				return 0;
		}
	}

	private int mapping(String s) {
		switch (s) {
		case "I":
			return 1;
		case "V":
			return 5;
		case "X":
			return 10;
		case "L":
			return 50;
		case "C":
			return 100;
		case "D":
			return 500;
		case "M":
			return 1000;
		case "IV":
			return 4;
		case "IX":
			return 9;
		case "XL":
			return 40;
		case "XC":
			return 90;
		case "CD":
			return 400;
		case "CM":
			return 900;
		default:
			return 0;
		}
	}
	
//	public static int romanToInt(String s) {
//		int ans = 0;
//		char[] cArray = s.toCharArray();
//		int preVal = 0;
//		for(int i = cArray.length - 1; i >= 0; i--) {
//			int val = 0;
//			switch(cArray[i]) {
//				case 'I':
//					val = 1;
//					break;
//				case 'V':
//					val = 5;
//					break;
//				case 'X':
//					val = 10;
//					break;
//				case 'L':
//					val = 50;
//					break;
//				case 'C':
//					val = 100;
//					break;
//				case 'D':
//					val = 500;
//					break;
//				case 'M':
//					val = 1000;
//					break;
//			}
//			
//			if(preVal > val) {
//				val = val * -1;
//			}
//			ans = ans + val;
//			preVal = val;
//		}
//		return ans;
//    }

}
