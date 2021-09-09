package easy.q111_MinimumDepthOfBinaryTree;

/**
 * @author Todd https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class Solution {
	public int minDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}else if(root.left == null && root.right == null) {
			return 1;
		}
		
		int depth = Integer.MAX_VALUE;
		if(root.left != null) {
			depth = Math.min(minDepth(root.left), depth);
		}
		if(root.right != null) {
			depth = Math.min(minDepth(root.right), depth);
		}
		
		return depth + 1;
	}
}
