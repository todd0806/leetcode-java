package easy.q111_MinimumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Todd https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class Solution {
	// BFS
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> stack = new LinkedList<>();
		stack.offer(root);
		int count = 1;
		while (!stack.isEmpty()) {
			int size = stack.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = stack.poll();
				if (node.left == null && node.right == null) {
					return count;
				}
				if (node.left != null) {
					stack.offer(node.left);
				}

				if (node.right != null) {
					stack.offer(node.right);
				}
			}
			count++;
		}
		return count - 1;
	}
	
//	public int minDepth(TreeNode root) {
//		if(root == null) {
//			return 0;
//		}else if(root.left == null && root.right == null) {
//			return 1;
//		}
//		
//		int depth = Integer.MAX_VALUE;
//		if(root.left != null) {
//			depth = Math.min(minDepth(root.left), depth);
//		}
//		if(root.right != null) {
//			depth = Math.min(minDepth(root.right), depth);
//		}
//		
//		return depth + 1;
//	}
}
