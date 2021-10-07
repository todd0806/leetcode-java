package medium.q433_MinimumGeneticMutation;

import java.util.Arrays;
import java.util.HashSet;

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
//	public int minMutation(String start, String end, String[] bank) {
//		// check 
//		if(start.equals(end)) {
//			return 0;
//		}
//		if(start == null || end == null || bank == null || bank.length == 0) {
//			return -1;
//		}
//		
//		// initialize
//		int steps = 0;
//		char[] leagalChar = new char[] {'A', 'C', 'G', 'T'};
//		HashSet<String> bankSet = new HashSet<>();
//		for(String item: bank) {
//			bankSet.add(item);
//		}
//		HashSet<String> checkedSet = new HashSet<>();
//		
//		Deque<String> deque = new LinkedList<>();
//		deque.add(start);
//		
//		// logic
//		while(!deque.isEmpty()) {
//			steps++;
//			int size = deque.size();
//			for(int i = 0; i < size; i++) {
//				String test = deque.pop();
//				
//				char[] testCharArray = test.toCharArray();
//				for(int j = 0; j < testCharArray.length; j++) {
//					char old = testCharArray[j];
//					for(char c: leagalChar) {
//						testCharArray[j] = c;
//						String next = String.valueOf(testCharArray);
//						if(next.equals(end) && bankSet.contains(next)) {
//							return steps;
//						}
//						if(!checkedSet.contains(next) && bankSet.contains(next)) {
//							deque.add(next);
//							checkedSet.add(next);
//						} 
//					}
//					// restore
//					testCharArray[j] = old;
//				}
//			}
//		}
//		return -1;
//	}
	
	// 雙向BFS
	public int minMutation(String start, String end, String[] bank) {
		HashSet<String> set = new HashSet<>(Arrays.asList(bank));
		if (!set.contains(end)) {
			return -1;
		}
		char[] four = { 'A', 'C', 'G', 'T' };
		HashSet<String> positive = new HashSet<String>() {
			{
				add(start);
			}
		};
		HashSet<String> negative = new HashSet<String>() {
			{
				add(end);
			}
		};
		HashSet<String> tempNewSet = new HashSet<>();
		int step = 0;
		while (positive.size() > 0 && negative.size() > 0) {
			step++;
			// 每次判断正向是否比负向的元素更多。我们选择元素更小的那个继续更新。
			if (positive.size() > negative.size()) {
				HashSet<String> temp = new HashSet<>(positive);
				positive = negative;
				negative = temp;
			}

			// 遍历每个正向的元素。
			for (String item : positive) {
				String str;
				char[] tempStringChars = item.toCharArray();
				for (int i = tempStringChars.length - 1; i >= 0; --i) {
					char oldChar = tempStringChars[i];
					for (int j = 0; j < 4; ++j) {
						tempStringChars[i] = four[j];
						String newString = new String(tempStringChars);
						if (negative.contains(newString)) {
							return step;
						} else if (set.contains(newString)) {
							set.remove(newString);
							tempNewSet.add(newString);
						}
					}
					tempStringChars[i] = oldChar;
				}
			}
			positive = new HashSet<>(tempNewSet);
			tempNewSet.clear();
		}
		return -1;
	}
}
