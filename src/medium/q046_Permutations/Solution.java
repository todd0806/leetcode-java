package medium.q046_Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Todd https://leetcode.com/problems/permutations/
 */
public class Solution {
	/**
	 * https://leetcode-cn.com/problems/permutations/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-hui-s-mfrp/
	 * @param nums
	 * @return
	 */
	
	private List<List<Integer>> result = new ArrayList<>();
	private LinkedList<Integer> path = new LinkedList<>();
	
	public List<List<Integer>> permute(int[] nums) {
		boolean[] used = new boolean[nums.length];
		permuteHelper(nums, used);
		return result;
	}
	
	private void permuteHelper(int[] nums, boolean[] used) {
		if(path.size() == nums.length) {
			result.add(new ArrayList<>(path));
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(used[i] == true) {
				continue;
			}
			
			path.add(nums[i]);
			used[i] = true;
			permuteHelper(nums, used);
			path.removeLast();
			used[i] = false;
		}
	}
}
