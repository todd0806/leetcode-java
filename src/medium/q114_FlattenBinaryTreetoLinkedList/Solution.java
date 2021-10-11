package medium.q114_FlattenBinaryTreetoLinkedList;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class Solution {

	// https://labuladong.gitee.io/algo/1/13/
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		flatten(root.left);
		flatten(root.right);

		TreeNode left = root.left;
		TreeNode right = root.right;

		root.left = null;
		root.right = left;

		TreeNode cur = root;
		while (cur.right != null) {
			cur = cur.right;
		}
		cur.right = right;
	}
}
