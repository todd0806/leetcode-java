package hard.q127_WordLadder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Todd
 *https://leetcode.com/problems/word-ladder/description/
 */
public class Solution {
	public static void main(String[] args) {
		new Solution().ladderLength("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
	}
	
	/**https://leetcode-cn.com/problems/word-ladder/solution/127-dan-ci-jie-long-wei-shi-yao-yao-yong-yan-sou-x/
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// check
		if(wordList == null || wordList.size() == 0 || wordList.indexOf(endWord) == -1 || beginWord.equals(endWord)) {
			return 0;
		}
		
		// prepare
		// wordSet
		HashSet<String> wordSet = new HashSet<>(wordList);
		// 記錄此字串最短路徑
		HashMap<String, Integer> wordStepsMap = new HashMap<>();
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		wordStepsMap.put(beginWord, 1);

		// logic
		while(!queue.isEmpty()) {
			String str = queue.poll();
			int steps = wordStepsMap.get(str);
			for(int i = 0; i < str.length(); i++) {
				char[] chars = str.toCharArray();
				for(char c = 'a'; c <= 'z'; c++) {
					chars[i] = c;
					String next = String.valueOf(chars);
					if(next.equals(endWord)) {
						return steps + 1;
					}
					if(wordSet.contains(next) && !wordStepsMap.containsKey(next)) {
						wordStepsMap.put(next, steps + 1);
						queue.add(next);
					}
				}
			}
		}
		return 0;
	}
}
