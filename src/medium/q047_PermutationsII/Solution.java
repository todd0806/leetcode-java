package medium.q047_PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Todd
 *https://leetcode.com/problems/permutations-ii/
 */
public class Solution {
	public static void main(String[] args) {
		new Solution().permuteUnique(new int[] {1, 1, 2});
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i])
					continue;
				// 剪枝
				if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
					continue;
				used[i] = true;
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, used);
				used[i] = false;
				tempList.remove(tempList.size() - 1);
			}
		}
	}
	/**
	 * 
	 * @param nums
	 * @return
	 */
//	private List<List<Integer>> result = new ArrayList<>();
//	private LinkedList<Integer> path = new LinkedList<>();
//	private Set<String> uniqueResult = new HashSet<>();
//	
//	public List<List<Integer>> permuteUnique(int[] nums) {
//		boolean[] used = new boolean[nums.length];
//		permuteHelper(nums, used);
//		return result;
//	}
//	
//	private void permuteHelper(int[] nums, boolean[] used) {
//		if(path.size() == nums.length) {
//			String s = String.join(",", path.stream().map(Object::toString).collect(Collectors.toList()));
//			if(!uniqueResult.contains(s)){
//				result.add(new ArrayList<>(path));
//				uniqueResult.add(s);
//			}
//		}
//		
//		for(int i = 0; i < nums.length; i++) {
//			if(used[i] == true) {
//				continue;
//			}
//			
//			path.add(nums[i]);
//			used[i] = true;
//			permuteHelper(nums, used);
//			path.removeLast();
//			used[i] = false;
//		}
//	}
}
