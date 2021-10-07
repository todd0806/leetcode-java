package hard.q127_WordLadder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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
//	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//		// check
//		if(wordList == null || wordList.size() == 0 || wordList.indexOf(endWord) == -1 || beginWord.equals(endWord)) {
//			return 0;
//		}
//		
//		// prepare
//		// wordSet
//		HashSet<String> wordSet = new HashSet<>(wordList);
//		// 記錄此字串最短路徑
//		HashMap<String, Integer> wordStepsMap = new HashMap<>();
//		Queue<String> queue = new LinkedList<>();
//		queue.add(beginWord);
//		wordStepsMap.put(beginWord, 1);
//
//		// logic
//		while(!queue.isEmpty()) {
//			String str = queue.poll();
//			int steps = wordStepsMap.get(str);
//			for(int i = 0; i < str.length(); i++) {
//				char[] chars = str.toCharArray();
//				for(char c = 'a'; c <= 'z'; c++) {
//					chars[i] = c;
//					String next = String.valueOf(chars);
//					if(next.equals(endWord)) {
//						return steps + 1;
//					}
//					if(wordSet.contains(next) && !wordStepsMap.containsKey(next)) {
//						wordStepsMap.put(next, steps + 1);
//						queue.add(next);
//					}
//				}
//			}
//		}
//		return 0;
//	}
	
	// 雙向BFS說明
	// https://leetcode-cn.com/problems/word-ladder/solution/gong-shui-san-xie-ru-he-shi-yong-shuang-magjd/
	// 雙向BFS寫得比較好的如下
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int end = wordList.indexOf(endWord);
		if (end == -1) {
			return 0;
		}
		wordList.add(beginWord);

		// 从两端 BFS 遍历要用的队列
		Queue<String> queue1 = new LinkedList<>();
		Queue<String> queue2 = new LinkedList<>();
		// 两端已经遍历过的节点
		Set<String> visited1 = new HashSet<>();
		Set<String> visited2 = new HashSet<>();
		queue1.offer(beginWord);
		queue2.offer(endWord);
		visited1.add(beginWord);
		visited2.add(endWord);

		int count = 0;
		Set<String> allWordSet = new HashSet<>(wordList);

		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			count++;
			if (queue1.size() > queue2.size()) {
				Queue<String> tmp = queue1;
				queue1 = queue2;
				queue2 = tmp;
				Set<String> t = visited1;
				visited1 = visited2;
				visited2 = t;
			}
			int size1 = queue1.size();
			while (size1-- > 0) {
				String s = queue1.poll();
				char[] chars = s.toCharArray();
				for (int j = 0; j < s.length(); ++j) {
					// 保存第j位的原始字符
					char c0 = chars[j];
					for (char c = 'a'; c <= 'z'; ++c) {
						chars[j] = c;
						String newString = new String(chars);
						// 已经访问过了，跳过
						if (visited1.contains(newString)) {
							continue;
						}
						// 两端遍历相遇，结束遍历，返回 count
						if (visited2.contains(newString)) {
							return count + 1;
						}
						// 如果单词在列表中存在，将其添加到队列，并标记为已访问
						if (allWordSet.contains(newString)) {
							queue1.offer(newString);
							visited1.add(newString);
						}
					}
					// 恢复第j位的原始字符
					chars[j] = c0;
				}
			}
		}
		return 0;
	}
}
