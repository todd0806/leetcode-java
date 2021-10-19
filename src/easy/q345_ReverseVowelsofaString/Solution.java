package easy.q345_ReverseVowelsofaString;

public class Solution {
	public String reverseVowels(String s) {
		int left = 0;
		int right = s.length() - 1;
		char[] chars = s.toCharArray();
		while (left < right) {
			if (isVowels(s.charAt(left)) && isVowels(s.charAt(right))) {
				chars[right] = s.charAt(left);
				chars[left] = s.charAt(right);
				left++;
				right--;
			} else if (!isVowels(s.charAt(left))) {
				left++;
			} else if (!isVowels(s.charAt(right))) {
				right--;
			}
		}
		return new String(chars);
	}

	private boolean isVowels(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U') {
			return true;
		} else {
			return false;
		}
	}
}
