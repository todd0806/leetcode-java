package easy.q026_RemoveDuplicatesFromSortedArray;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class Solution {
	
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		System.out.print(removeDuplicates(nums));
	}
	
	public static int removeDuplicates(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		int preNum = nums[0];
		int ans = 1;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] != preNum) {
				nums[ans] = nums[i];
				ans++;
				preNum = nums[i];
				
			}
		}
        return ans;
    }
}
