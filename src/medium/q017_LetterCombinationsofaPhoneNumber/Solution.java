package medium.q017_LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Todd
 *         https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Solution {
	private HashMap<Character, String> mapping = new HashMap<Character, String>();
	private List<String> result = new ArrayList<>();
	private LinkedList<String> path = new LinkedList<>();

	public List<String> letterCombinations(String digits) {
		if ("".equals(digits)) {
			return new ArrayList<>();
		}

		mapping.put('2', "abc");
		mapping.put('3', "def");
		mapping.put('4', "ghi");
		mapping.put('5', "jkl");
		mapping.put('6', "mno");
		mapping.put('7', "pqrs");
		mapping.put('8', "tuv");
		mapping.put('9', "wxyz");
		combine(digits, 0);
		return result;
	}

	private void combine(String digits, int level) {
		if (digits.length() == level) {
			result.add(path.stream().collect(Collectors.joining()));
			return;
		}

		String value = mapping.get(digits.charAt(level));
		for (int i = 0; i < value.length(); i++) {
			path.add(String.valueOf(value.charAt(i)));
			combine(digits, level + 1);
			path.pollLast();
		}
	}

}
