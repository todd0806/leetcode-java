package easy.q058_LengthOfLastWord;

//https://leetcode.com/problems/length-of-last-word/

public class Solution {

	public static void main(String[] args) {
		System.out.print(lengthOfLastWord(" "));
	}

	public static int lengthOfLastWord(String s) {
		 int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				count++;
			} else {
				if (count > 0) {
					break;
				}
			}
		}
		return count;
	}

	
//	public static int lengthOfLastWord(String s) {
//		String[] array = s.split(" ");
//		for (int i = array.length - 1; i >= 0; i--) {
//			if (array[i].length() > 0) {
//				return array[i].length();
//			}
//		}
//		return 0;
//	}

	
//	public static int lengthOfLastWord(String s) {
//		int len = 0;
//		for(int i = s.length() - 1; i >= 0; i--) {
//			if(s.charAt(i) == ' ' && len > 0) {
//				return len;
//			}else {
//				if(s.charAt(i) != ' ') {
//					len++;
//				}
//			}
//		}
//		return len;
//	}
}
