package easy.q001_TwoSum;

import java.util.HashMap;

//https://leetcode.com/problems/two-sum/
public class Solution {

	public static void main(String[] args) {
//		System.out.print("test");
		int[] ints = { 2, 7, 11, 15 };
		System.out.print(twoSum(ints, 9));
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] returnArray = { 0, 0 };
		// <value, index>
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int remain = target - nums[i];
			if (map.containsKey(remain)) {
				returnArray[0] = map.get(remain);
				returnArray[1] = i;
				return returnArray;
			}
			map.put(nums[i], i);
		}
		return returnArray;
	}

}
