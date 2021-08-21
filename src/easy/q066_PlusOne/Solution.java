package easy.q066_PlusOne;

//https://leetcode.com/problems/plus-one/

public class Solution {

	public static void main(String[] args) {
		int[] nums = {8,9};
		System.out.print(plusOne(nums));
	}

	public static int[] plusOne(int[] digits) {
		int carry = 0;
		if(digits == null || digits.length == 0) {
			return digits;
		}
		
		digits[digits.length - 1]++;
		for(int i = digits.length - 1; i >= 0; i--) {
			if(digits[i] >= 10) {
				carry++;
				digits[i] = 0;
			}else {
				return digits;
			}
			//carry
			if(carry != 0 && i != 0) {
				digits[i - 1]++;
				carry = 0;
			}
		}
		//carry--->need a new array
		if(carry > 0) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = 1;
			for(int i = 0; i < digits.length; i++) {
				newDigits[i+1] = digits[i];
			}
			return newDigits;
		}
		return digits;
	}
}
