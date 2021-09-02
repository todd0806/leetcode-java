package medium.q015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Todd 
 * https://leetcode.com/problems/3sum/
 * 1. 所有可能解法
 * 	a. 暴力求解 a + b = -c(target)--->類似Two Sum-->三重循環O(n^3)
 * 
 * 不錯的解：
 * https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
 */
public class Solution {
	public static void main(String[] args) {
		int[] nums = {-2,0,0,2,2};
		System.out.print(threeSum(nums).toString());
	}
	
	
	/**先排序再用雙指針找
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for(int k = 0; k < nums.length - 2;k++) {
			// 最小的值都>0-->無解
			if(nums[k] > 0) {
				break;
			}
			
			// 往右推進k，若nums[k]遇到一樣的則跳過
			if(k > 0 && nums[k] == nums[k - 1]) {
				continue;
			}
			
			int i = k + 1;
			int j = nums.length - 1;
			while(i < j) {
				int sum = nums[k] + nums[i] + nums[j];
				if(sum == 0) {
					List<Integer> solution = Arrays.asList(nums[k], nums[i], nums[j]);
					result.add(solution);
					while(i < j && nums[i] == nums[++i]);
					while(i < j && nums[j] == nums[--j]);
				}else if(sum > 0) {
					while(i < j && nums[j] == nums[--j]);
				}else if(sum < 0) {
					while(i < j && nums[i] == nums[++i]);
				}
			}
		}
		return result;
	}
	
	
	/**暴力法--->Time Limit Exceeded
	 * @param nums
	 * @return
	 */
//	public static List<List<Integer>> threeSum(int[] nums) {
//		List<List<Integer>> result = new ArrayList<>();
//		Set<String> resultSet = new HashSet<>();
//		for(int i = 0; i < nums.length - 2; i++) {
//			for(int j = i + 1; j < nums.length - 1; j++) {
//				for(int k = j + 1; k < nums.length; k++) {
//					if( nums[i] + nums[j] + nums[k] == 0) {
//						List<Integer> ans = new ArrayList<>();
//						ans.add(nums[i]);
//						ans.add(nums[j]);
//						ans.add(nums[k]);
//						Collections.sort(ans);
//						if(!resultSet.contains(ans.toString())) {
//							result.add(ans);
//							resultSet.add(ans.toString());
//						}
//					}
//				}
//			}
//		}
//		return result;
//	}
}
