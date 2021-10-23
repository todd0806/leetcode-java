package easy.q035_ImplementStrstr;

//https://leetcode.com/problems/implement-strstr/

public class Solution {

	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		System.out.print(new Solution().searchInsert(nums, 3));
	}
	
	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (target > nums[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		if (right < 0) {
			return 0;
		} else if (left >= nums.length) {
			return nums.length;
		} else {
			return left;
		}
	}

//	public static int searchInsert(int[] nums, int target) {
//		int ans = -1;
//		int inserIndex = -1;
//		for(int i = 0; i < nums.length; i++) {
//			if(nums[i]== target) {
//				return i;
//			}
//			if(inserIndex == -1 && target <= nums[i]) {
//				inserIndex = i;
//			}
//		}
//		
//		if(ans == -1) {
//			return inserIndex == -1 ? nums.length: inserIndex;
//		}else {
//			return ans;
//		}
//	}
}
