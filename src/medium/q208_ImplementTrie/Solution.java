package medium.q208_ImplementTrie;

import java.util.HashMap;

/**
 * @author Todd
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Solution {
	// https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/208-shi-xian-trie-qian-zhui-shu-bao-gua-insert-sea/
	class Trie {
		public int path;
		public int end;
		public HashMap<Character, Trie> next;
		
		public Trie() {
			path = 0;
			end = 0;
			next = new HashMap<>();
		}

		public void insert(String word) {
			Trie node = this;
			for(char c: word.toCharArray()) {
				if(!node.next.containsKey(c)) {
					Trie nextNode = new Trie();
					node.next.put(c, nextNode);
				}
				node = node.next.get(c);
				node.path++;
			}
			node.end++;
		}

		public boolean search(String word) {
			Trie node = this;
			for(char c: word.toCharArray()) {
				if(!node.next.containsKey(c)) {
					return false;
				}
				node = node.next.get(c);
			}
			return node.end > 0;
		}

		public boolean startsWith(String prefix) {
			Trie node = this;
			for(char c: prefix.toCharArray()) {
				if(!node.next.containsKey(c)) {
					return false;
				}
				node = node.next.get(c);
			}
			return node.end >= 0;
		}
	}

}
