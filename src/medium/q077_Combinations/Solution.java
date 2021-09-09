package medium.q077_Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Todd https://leetcode.com/problems/combinations/
 */
public class Solution {
	
	/**https://leetcode-cn.com/problems/combinations/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-hui-s-0uql/
	 * @param n
	 * @param k
	 * @return
	 */
	
	private List<List<Integer>> result = new ArrayList<>();
	private LinkedList<Integer> path = new LinkedList<>();
	
	public List<List<Integer>> combine(int n, int k) {
		combine(n, k, 1);
		return result;
	}
	
	private void combine(int n, int k, int startIndex) {
		if(path.size() == k) {
			result.add(new ArrayList<>(path));
			return;
		}
		
		for(int i = startIndex; i <= n; i++) {
			path.add(i);
			combine(n, k, i + 1);
			path.removeLast();
		}
	}
	
}
