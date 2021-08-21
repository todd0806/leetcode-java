package easy.q058_LengthOfLastWord;

//https://leetcode.com/problems/length-of-last-word/

public class Solution {

	public static void main(String[] args) {
		System.out.print(lengthOfLastWord(" "));
	}

	public static int lengthOfLastWord(String s) {
		int len = 0;
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == ' ' && len > 0) {
				return len;
			}else {
				if(s.charAt(i) != ' ') {
					len++;
				}
			}
		}
		return len;
	}
}
