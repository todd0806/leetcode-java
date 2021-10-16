package easy.q392_IsSubsequence;

// https://leetcode.com/problems/is-subsequence/
public class Solution {
	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0) {
			return true;
		}
		if (s.length() == 0 && t.length() > 0) {
			return false;
		}
		int sIndex = 0;
		int tIndex = 0;
		while (tIndex < t.length()) {
			if (s.charAt(sIndex) == t.charAt(tIndex)) {
				sIndex++;
				if (sIndex == s.length()) {
					return true;
				}
			}
			tIndex++;
		}
		return false;
	}

}
