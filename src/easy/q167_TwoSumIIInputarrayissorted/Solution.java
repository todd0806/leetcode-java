package easy.q167_TwoSumIIInputarrayissorted;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int left = 0, right = numbers.length - 1;
		while (left < right) {
			if (numbers[left] + numbers[right] == target) {
				return new int[] { left + 1, right + 1 };
			} else if (numbers[left] + numbers[right] > target) {
				right--;
			} else if (numbers[left] + numbers[right] < target) {
				left++;
			}
		}
		return null;
	}
}
