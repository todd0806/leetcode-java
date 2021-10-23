package easy.q108_ConvertSortedArraytoBinarySearchTree;

public class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
		return transfer(nums, 0, nums.length - 1);
	}

	private TreeNode transfer(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}

		int mid = left + (right - left) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = transfer(nums, left, mid - 1);
		node.right = transfer(nums, mid + 1, right);
		return node;
	}
}
