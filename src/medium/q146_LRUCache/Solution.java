package medium.q146_LRUCache;

import java.util.LinkedHashMap;

// https://leetcode.com/problems/lru-cache/#/
public class Solution {
	// https://leetcode-cn.com/problems/lru-cache/solution/java-shi-yong-linkedhashmapshi-xian-lru-t279i/
	class LRUCache {

		LinkedHashMap<Integer, Integer> map;
		int size;
		
		public LRUCache(int capacity) {
			this.map = new LinkedHashMap<Integer, Integer>();
			this.size = capacity;
		}

		public int get(int key) {
			if(!map.containsKey(key)) {
				return -1;
			}else {
				int val = map.get(key);
				map.remove(key);
				map.put(key, val);
				return val;
			}
		}

		public void put(int key, int value) {
			if(map.containsKey(key)) {
				map.remove(key);
				map.put(key, value);
			}else {
				map.put(key, value);
			}
			
			if(map.size() > size) {
				map.remove(map.entrySet().iterator().next().getKey());
			}
		}
	}
}
