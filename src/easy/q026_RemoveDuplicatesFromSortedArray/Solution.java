package easy.q026_RemoveDuplicatesFromSortedArray;

import java.util.HashMap;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class Solution {
	
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		System.out.print(new Solution().removeDuplicates(nums));
	}
	
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}

		int left = 1;
		int oldValue = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (oldValue != nums[i]) {
				nums[left++] = nums[i];
				oldValue = nums[i];
			}
		}
		return left;
	}
	
//	public int removeDuplicates(int[] nums) {
//		// num, count
//		HashMap<Integer, Integer> map = new HashMap<>();
//		int left = 0;
//		for (int i = 0; i < nums.length; i++) {
//			int count = map.getOrDefault(nums[i], 0);
//			if (count == 0) {
//				nums[left] = nums[i];
//				map.put(nums[i], 1);
//				left++;
//			}
//		}
//		return left;
//	}
	
//	public static int removeDuplicates(int[] nums) {
//		if(nums.length == 0) {
//			return 0;
//		}
//		int preNum = nums[0];
//		int ans = 1;
//		for(int i = 1; i < nums.length; i++) {
//			if(nums[i] != preNum) {
//				nums[ans] = nums[i];
//				ans++;
//				preNum = nums[i];
//				
//			}
//		}
//        return ans;
//    }
}
