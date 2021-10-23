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

		int ans = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left == null && node.right == null) {
					return ans;
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			ans++;
		}
		return ans;
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
