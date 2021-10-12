package medium.q654_MaximumBinaryTree;

//https://leetcode.com/problems/maximum-binary-tree/
public class Solution {
//	https://labuladong.gitee.io/algo/2/19/23/
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return build(nums, 0, nums.length - 1);
	}

	private TreeNode build(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = left; i <= right; i++) {
			if (nums[i] > max) {
				max = nums[i];
				maxIndex = i;
			}
		}

		TreeNode root = new TreeNode(max);
		root.left = build(nums, left, maxIndex - 1);
		root.right = build(nums, maxIndex + 1, right);
		return root;
	}
}
