package medium.q078_Subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Todd https://leetcode.com/problems/subsets/
 */
public class Solution {
	
	/**參考
	 * https://leetcode-cn.com/problems/subsets/solution/zi-ji-java-by-sui-ji-guo-cheng-sui-ji-gu-8v52/
	 * @param nums
	 * @return
	 */
	private List<List<Integer>> result = new ArrayList<>();
	private LinkedList<Integer> path = new LinkedList<>(); 
	public List<List<Integer>> subsets(int[] nums) {
		bracket(nums, 0);
		return result;
	}
	
	private void bracket(int[] nums, int startIndex) {
		if(startIndex > nums.length) {
			return;
		}
		
		result.add(new ArrayList<>(path));
		for(int i = startIndex; i < nums.length; i++) {
			path.push(nums[i]);
			bracket(nums, i + 1);
			path.removeLast();
		}
	}
	
	
}
