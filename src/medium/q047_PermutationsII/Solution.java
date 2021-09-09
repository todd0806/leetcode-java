package medium.q047_PermutationsII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Todd
 *https://leetcode.com/problems/permutations-ii/
 */
public class Solution {
	/**
	 * 
	 * @param nums
	 * @return
	 */
	private List<List<Integer>> result = new ArrayList<>();
	private LinkedList<Integer> path = new LinkedList<>();
	private Set<String> uniqueResult = new HashSet<>();
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		boolean[] used = new boolean[nums.length];
		permuteHelper(nums, used);
		return result;
	}
	
	private void permuteHelper(int[] nums, boolean[] used) {
		if(path.size() == nums.length) {
			String s = String.join(",", path.stream().map(Object::toString).collect(Collectors.toList()));
			if(!uniqueResult.contains(s)){
				result.add(new ArrayList<>(path));
				uniqueResult.add(s);
			}
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