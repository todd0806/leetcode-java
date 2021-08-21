package easy.q028_ImplementStrstr;

//https://leetcode.com/problems/implement-strstr/

public class Solution {

	public static void main(String[] args) {
		System.out.print(strStr("hello", "ll"));
	}

	public static int strStr(String haystack, String needle) {
		if(needle.isEmpty()) {
			return 0;
		}
		
		int h = haystack.length();
		int n = needle.length();
		for(int i = 0; i < h - n + 1; i++) {
			for(int j = 0; j < n; j++) {
				if(haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}else {
					if(j == n - 1) {
						return i;
					}
				}
			}
		}
		
		return -1;
	}
}
