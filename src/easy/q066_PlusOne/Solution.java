package easy.q066_PlusOne;

//https://leetcode.com/problems/plus-one/

public class Solution {

	public static void main(String[] args) {
		int[] nums = {8,9};
		System.out.print(new Solution().plusOne(nums));
	}

	public int[] plusOne(int[] digits) {
		for(int i = digits.length - 1; i >= 0; i--){
			if(digits[i] < 9){
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		
		int[] newDigits = new int[digits.length + 1];
		newDigits[0] = 1;
		return newDigits;
	}


}
