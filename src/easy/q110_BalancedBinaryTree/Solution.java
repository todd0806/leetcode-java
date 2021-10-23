package easy.q110_BalancedBinaryTree;

public class Solution {
	boolean result = true;

	public boolean isBalanced(TreeNode root) {
		maxDepth(root);
		return result;
	}

	private int maxDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		if (result == false) {
			return 0;
		}

		int leftDepth = maxDepth(node.left);
		int rightDepth = maxDepth(node.right);
		//平衡樹的定義為：對於每個節點，它左右子樹的高度相差必須小於等於一。
		if (Math.abs(leftDepth - rightDepth) > 1) {
			result = false;
		}
		return 1 + Math.max(leftDepth, rightDepth);
	}

}
