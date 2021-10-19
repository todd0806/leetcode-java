package medium.q524_LongestWordinDictionarythroughDeleting;

import java.util.List;

public class Solution {
	public static void main(String[] args) {
		// - 2
		System.out.println("a".compareTo("c"));
		
	}
	
	// http://www.cyc2018.xyz/%E7%AE%97%E6%B3%95/Leetcode%20%E9%A2%98%E8%A7%A3/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E5%8F%8C%E6%8C%87%E9%92%88.html#_7-%E6%9C%80%E9%95%BF%E5%AD%90%E5%BA%8F%E5%88%97
	public String findLongestWord(String s, List<String> dictionary) {
		String longest = "";
		for (String t : dictionary) {
			int longestLenth = longest.length();
			int tLength = t.length();
			if (longestLenth > tLength || (longestLenth == tLength && longest.compareTo(t) < 0)) {
				continue;
			}

			if (isSubstr(s, t)) {
				longest = t;
			}
		}
		return longest;
	}

	private boolean isSubstr(String s, String t) {
		int sIndex = 0, tIndex = 0;
		while (sIndex < s.length() && tIndex < t.length()) {
			if (s.charAt(sIndex) == t.charAt(tIndex)) {
				sIndex++;
				tIndex++;
			} else {
				sIndex++;
			}
		}

		return tIndex == t.length();
	}
}
