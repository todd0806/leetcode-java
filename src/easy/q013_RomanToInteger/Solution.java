package easy.q013_RomanToInteger;

//https://leetcode.com/problems/roman-to-integer/
public class Solution {
	
	public static void main(String[] args) {
		System.out.print(romanToInt("MCMXCIV"));
	}
	
	public static int romanToInt(String s) {
		int ans = 0;
		char[] cArray = s.toCharArray();
		int preVal = 0;
		for(int i = cArray.length - 1; i >= 0; i--) {
			int val = 0;
			switch(cArray[i]) {
				case 'I':
					val = 1;
					break;
				case 'V':
					val = 5;
					break;
				case 'X':
					val = 10;
					break;
				case 'L':
					val = 50;
					break;
				case 'C':
					val = 100;
					break;
				case 'D':
					val = 500;
					break;
				case 'M':
					val = 1000;
					break;
			}
			
			if(preVal > val) {
				val = val * -1;
			}
			ans = ans + val;
			preVal = val;
		}
		return ans;
    }

}
