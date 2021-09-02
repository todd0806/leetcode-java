package medium.q049GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Todd
 *https://leetcode.com/problems/group-anagrams/
 */
public class Solution {
	public static void main(String[] args) {
		String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
		new Solution().groupAnagrams(strs);
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
		for(String s: strs) {
			char[] charArray = s.toCharArray();
			Arrays.sort(charArray);
			if(!hashMap.containsKey(String.valueOf(charArray))) {
				hashMap.put(String.valueOf(charArray), new ArrayList<>());
			}
			hashMap.get(String.valueOf(charArray)).add(s);
		}
		return new ArrayList<>(hashMap.values());
	}
}
