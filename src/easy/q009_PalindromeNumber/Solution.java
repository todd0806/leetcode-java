package easy.q009_PalindromeNumber;

//https://leetcode.com/problems/palindrome-number/
public class Solution {
	
	public static void main(String[] args) {
		System.out.print(isPalindrome(1));
	}
	
	public static boolean isPalindrome(int x) {
		if(x < 0) {
			return false;
		}
		
		long ans = 0;
		int y = x;
		while(y != 0) {
			ans = ans * 10 + y % 10;
			y = y / 10;
		}
		if(ans == x) {
			return true;
		}else {
			return false;
		}
    }

}
