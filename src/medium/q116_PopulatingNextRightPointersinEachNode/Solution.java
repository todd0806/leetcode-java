package medium.q116_PopulatingNextRightPointersinEachNode;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
public class Solution {
	// https://labuladong.gitee.io/algo/1/13/
	public Node connect(Node root) {
		if (root == null) {
			return null;
		}

		connectTwoNode(root.left, root.right);
		return root;
	}

	public void connectTwoNode(Node left, Node right) {
		if (left == null || right == null) {
			return;
		}

		left.next = right;
		connectTwoNode(left.left, left.right);
		connectTwoNode(right.left, right.right);
		connectTwoNode(left.right, right.left);
	}
}
