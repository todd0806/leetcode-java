package medium.q433_MinimumGeneticMutation;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Todd
 *https://leetcode.com/problems/minimum-genetic-mutation/
 */
public class Solution {
	
	/**https://leetcode.com/problems/minimum-genetic-mutation/discuss/91484/Java-Solution-using-BFS
	 * @param start
	 * @param end
	 * @param bank
	 * @return
	 */
	public int minMutation(String start, String end, String[] bank) {
		// check 
		if(start.equals(end)) {
			return 0;
		}
		if(start == null || end == null || bank == null || bank.length == 0) {
			return -1;
		}
		
		// initialize
		int steps = 0;
		char[] leagalChar = new char[] {'A', 'C', 'G', 'T'};
		HashSet<String> bankSet = new HashSet<>();
		for(String item: bank) {
			bankSet.add(item);
		}
		HashSet<String> checkedSet = new HashSet<>();
		
		Deque<String> deque = new LinkedList<>();
		deque.add(start);
		
		// logic
		while(!deque.isEmpty()) {
			steps++;
			int size = deque.size();
			for(int i = 0; i < size; i++) {
				String test = deque.pop();
				
				char[] testCharArray = test.toCharArray();
				for(int j = 0; j < testCharArray.length; j++) {
					char old = testCharArray[j];
					for(char c: leagalChar) {
						testCharArray[j] = c;
						String next = String.valueOf(testCharArray);
						if(next.equals(end) && bankSet.contains(next)) {
							return steps;
						}
						if(!checkedSet.contains(next) && bankSet.contains(next)) {
							deque.add(next);
							checkedSet.add(next);
						} 
					}
					// restore
					testCharArray[j] = old;
				}
			}
		}
		return -1;
	}
}
