package easy.q027_RemoveElement;

//https://leetcode.com/problems/remove-element/

public class Solution {

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		System.out.print(new Solution().removeElement(nums, 2));
	}

	public int removeElement(int[] nums, int val) {
		int ans = nums.length;
		int left = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				ans--;
			} else {
				nums[left++] = nums[i];
			}
		}
		return ans;
	}

//	public static int removeElement(int[] nums, int val) {
//		int ans = 0;
//		for(int i = 0; i < nums.length; i++) {
//			if(nums[i] == val) {
//				nums[ans] = nums[i];
//				ans++;
//			}
//		}
//		return ans;
//	}
}
