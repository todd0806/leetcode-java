package easy.q242_ValidAnagram;

import java.util.Arrays;
import java.util.HashMap;

import sun.security.provider.SHA;

/**
 * @author Todd
 *https://leetcode.com/problems/valid-anagram/description/
 */
public class Solution {
	public static void main(String[] args) {
		new Solution().isAnagram("anagram", "nagaram");
	}
	
	/**
	 * @param s
	 * @param t
	 * @return
	 * 
	 * 2. hash map-->統計每個字母的次數 
	 */
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		
		HashMap<Character, Integer> sHashMap = new HashMap<>();
		for(Character c : s.toCharArray()) {
			sHashMap.put(c, sHashMap.getOrDefault(c, 0) + 1);
		}
		
		for(Character c : t.toCharArray()) {
			int count = sHashMap.getOrDefault(c, 0);
			if(count == 0) {
				return false;
			}else {
				sHashMap.put(c, count - 1);
			}
		}
		
		return true;
	}
	
	/**
	 * @param s
	 * @param t
	 * @return
	 * 
	 * 1. 暴力，sort, sorted_str相等？ O(NlogN)
	 */
//	public boolean isAnagram(String s, String t) {
//		char[] sArray = s.toCharArray();
//		char[] tArray = t.toCharArray();
//		Arrays.sort(sArray);
//		Arrays.sort(tArray);
//		return String.valueOf(sArray).equals(String.valueOf(tArray));
//	}
}
