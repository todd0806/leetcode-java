package easy.q226_InvertBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Todd
 *https://leetcode.com/problems/invert-binary-tree/description/
 */
public class Solution {
	// BFS
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		return root;
	}
//	// DFS
//	public TreeNode invertTree(TreeNode root) {
//		invert(root);
//		return root;
//	}
//	
//	private void invert(TreeNode root) {
//		// terminator
//		if(root == null) {
//			return;
//		}
//		
//		// process logic
//		TreeNode temp = root.left;
//		root.left = root.right;
//		root.right = temp;
//		
//		// drilldown
//		invert(root.left);
//		invert(root.right);
//		
//		// reverse state
//	}
}
