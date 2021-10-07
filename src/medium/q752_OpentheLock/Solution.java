package medium.q752_OpentheLock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/open-the-lock/
public class Solution {
	// https://labuladong.gitbook.io/algo/mu-lu-ye/bfs-kuang-jia#san-jie-kai-mi-ma-suo-de-zui-shao-ci-shu
	public int openLock(String[] deadends, String target) {
		Set<String> visited = new HashSet<String>();
		visited.addAll(Arrays.asList(deadends));

		if(visited.contains("0000")) {
			return -1;
		}
		
		Queue<String> queue = new LinkedList<>();
		queue.offer("0000");
		visited.add("0000");
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				String item = queue.poll();
				if(item.equals(target)) {
					return count;
				}
				
				for(int j = 0; j < 4; j++) {
					String upItem = dialUp(item, j);
					if(!visited.contains(upItem)) {
						queue.offer(upItem);
						visited.add(upItem);
					}
					
					String downItem = dialDown(item, j);
					if(!visited.contains(downItem)) {
						queue.offer(downItem);
						visited.add(downItem);
					}
				}
			}
			count++;
		}
		return -1;
	}
	
	private String dialUp(String item, int index) {
		char[] chars = item.toCharArray();
		if(item.charAt(index) == '9') {
			chars[index] = '0';
		}else {
			chars[index] += 1;
		}
		return String.valueOf(chars);
	}
	
	private String dialDown(String item, int index) {
		char[] chars = item.toCharArray();
		if(item.charAt(index) == '0') {
			chars[index] = '9';
		}else {
			chars[index] -= 1;
		}
		return String.valueOf(chars);
	}

}
