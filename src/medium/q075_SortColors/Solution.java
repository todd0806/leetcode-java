package medium.q075_SortColors;

public class Solution {

//	https://leetcode.com/problems/sort-colors/discuss/1524750/Java-using-pointers-only-with-one-pass

	public void sortColors(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		for (int i = 0; i <= high; i++) {
			if (nums[i] == 2) {
				swap(nums, i, high);
				high--;
				i--;
			} else if (nums[i] == 0) {
				swap(nums, i, low);
				low++;
			}
		}
	}

	private void swap(int[] nums, int leftIndex, int rightIndex) {
		int temp = nums[leftIndex];
		nums[leftIndex] = nums[rightIndex];
		nums[rightIndex] = temp;
	}

}
